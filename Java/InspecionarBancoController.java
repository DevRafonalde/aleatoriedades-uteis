import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

@RestController
public class InspecionarBancoController {

    private final DataSource dataSource;

    public InspecionarBancoController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @GetMapping(path = "/api/debug/schema")
    public ResponseEntity<Map<String, List<Map<String, Object>>>> getSchema() throws Exception {
        Map<String, List<Map<String, Object>>> schema = new LinkedHashMap<>();

        try (Connection conn = dataSource.getConnection()) {
            DatabaseMetaData meta = conn.getMetaData();
            String nomeSchema = conn.getMetaData().getUserName();
            ResultSet tabelas = meta.getTables(null, nomeSchema, "%", new String[]{"TABLE"});

            while (tabelas.next()) {

                String nomeTabela = tabelas.getString("TABLE_NAME");
                List<Map<String, Object>> colunas = new ArrayList<>();

                ResultSet cols = meta.getColumns(null, nomeSchema, nomeTabela, "%");

                while (cols.next()) {

                    Map<String, Object> coluna = new LinkedHashMap<>();

                    coluna.put("name", cols.getString("COLUMN_NAME"));
                    coluna.put("type", cols.getString("TYPE_NAME"));
                    coluna.put("size", cols.getInt("COLUMN_SIZE"));
                    coluna.put("nullable", cols.getString("IS_NULLABLE"));

                    colunas.add(coluna);
                }

                schema.put(nomeTabela, colunas);
            }
        }

        return new ResponseEntity<>(schema, HttpStatus.OK);
    }
}

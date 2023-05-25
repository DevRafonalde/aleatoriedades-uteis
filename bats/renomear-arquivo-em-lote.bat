@echo off

setlocal enabledelayedexpansion

set "folder_path=caminho\para\pasta\origem"
set "destination_folder=caminho\para\pasta\destino"
set "num_digits=qntdDigitos"

set index=0

for %%F in ("%folder_path%\*") do (
    if exist "%%F" (
        set /a "index+=1"
        set "file_name=%%~nxF"
        set "new_file_name=!file_name:~2!"
        set "new_file_name=!index:~-%num_digits%!%new_file_name%"
        
        set /a "folder_number=index/1000"
        set "destination_folder_path=%destination_folder%\!folder_number!"

        if not exist "!destination_folder_path!" (
            mkdir "!destination_folder_path!"
        )

        move "%%F" "!destination_folder_path!\!new_file_name!"
        
    )
)

endlocal

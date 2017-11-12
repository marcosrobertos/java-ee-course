rem - Netbeans Executor File -

rem - Instructions:
rem   - Set the RHICOM_HOME environment variable in the OS.
rem   - Feel free to edit IDE_FOLDER and JDK_FOLDER local variables.
rem   - Both folders have to be located in %RHISCOM_HOME%\tools folder.

@echo off
set IDE_FOLDER=netbeans-8.1
set JDK_FOLDER=jdk1.7.0_40
rem set JDK_FOLDER=jdk1.8.0_121

rem DO NOT EDIT THESE AREA
for %%a in (.) do set PROJECT_NAME=%%~na
set JAVA_HOME=%RHISCOM_HOME%\tools\%JDK_FOLDER%
set VM=%JAVA_HOME%\bin\javaw.exe
set USER_DIR=%RHISCOM_HOME%\conf\netbeans\%PROJECT_NAME%
cd %RHISCOM_HOME%\tools\%IDE_FOLDER%\bin
start "" netbeans64 --jdkhome %JAVA_HOME% --userdir %USER_DIR% --console suppress
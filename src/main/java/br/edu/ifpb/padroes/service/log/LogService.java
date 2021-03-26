package br.edu.ifpb.padroes.service.log;

public class LogService{

    public LogService(LogHandler logHandler) {
        this.logHandler = logHandler;
    }

    private LogHandler logHandler;

    public void debug(String message) {
        logHandler.log("stack trace");
        logHandler.log(message);
    }

    public void info(String message) {
        logHandler.log(message);
    }
    public void error(String message) {
        logHandler.log("error");
        logHandler.log(message);
    }
}

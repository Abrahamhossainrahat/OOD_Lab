abstract class AbstractLogger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;
    public int level;
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger){
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message){
        if(this.level <= level){
            write(message);
        }
        if(nextLogger != null){
            nextLogger.logMessage(level, message);
        }
    }
    abstract protected void write(String message);
}


class ConsoleLogger extends AbstractLogger {
    public ConsoleLogger(int level ){
        this.level = level;
    }

    protected void write(String message){
        System.out.println("Message Colsole: " + message);
    }
}

class ErrorLogger extends AbstractLogger {
    public ErrorLogger(int level ){
        this.level = level;
    }

    protected void write(String message){
        System.out.println("Message Error : " + message);
    }
}

class FileLogger extends AbstractLogger {
    public FileLogger(int level ){
        this.level = level;
    }

    protected void write(String message){
        System.out.println("Message File : " + message);
    }
}


public class ChainOfResponsibilityPattern {

    private static AbstractLogger getChain(){
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fiLogger = new FileLogger((AbstractLogger.DEBUG));
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
        errorLogger.setNextLogger(fiLogger);
        fiLogger.setNextLogger(consoleLogger);
        return errorLogger;
    }
    public static void main(String[] args) {
        AbstractLogger loggerChain = getChain();
        loggerChain.logMessage(AbstractLogger.INFO, "This is info");
        loggerChain.logMessage(AbstractLogger.DEBUG, "This is debug");
        loggerChain.logMessage(AbstractLogger.ERROR, "This is error");

        
    }
}

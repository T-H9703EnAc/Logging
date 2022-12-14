package com.app.sample1;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogSample1 {
	
	public void execute() {
		// Loggerクラスのインスタンスを生成
        Logger logger = Logger.getLogger(LogSample1.class.getName());
 
        try {
            // Handlerを生成しloggerに登録
            FileHandler fHandler = new FileHandler(".\\src\\main\\resources\\Sample.log", true);
            fHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fHandler);
 
            // ログレベルの設定
            logger.setLevel(Level.INFO);
 
            // Loggerクラスのメソッドを使ってメッセージを出力
            logger.finest("FINEST");
            logger.finer("FINER");
            logger.fine("FINE");
            logger.config("CONFIG");
            logger.info("INFO");
            logger.warning("WARNING");
            logger.severe("SEVERE");
 
            // 例外をスロー
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            logger.log(Level.INFO, "例外のスローを捕捉", e);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}

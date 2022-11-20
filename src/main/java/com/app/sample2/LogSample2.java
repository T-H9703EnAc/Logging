package com.app.sample2;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Logの設定を外部ファイルに記載
 *
 */
public class LogSample2 {
	public void execute() {
		// Loggerクラスのインスタンスを生成
        Logger logger = Logger.getLogger(LogSample2.class.getName());
        // ログ設定ファイル
        String strpass = Paths.get("").toAbsolutePath().toString() + "\\src\\main\\resources\\logging.properties";
        try {
            // LogManagerのインスタンスを生成しlogging.propertiesを読み込む
            LogManager manager = LogManager.getLogManager();
            manager.readConfiguration(new FileInputStream(strpass));
 
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

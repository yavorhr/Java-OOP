package controllers;

import enums.ReportLevel;
import interfaces.Appender;
import interfaces.Logger;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractLogger implements Logger {
  private List<Appender> appenders;

  protected AbstractLogger(Appender... appenders) {
    this.appenders = Arrays.asList(appenders);
  }

  @Override
  public void logInfo(String date, String message) {
    callAllAppenders(date, ReportLevel.INFO, message);
  }

  @Override
  public void logWarning(String date, String message) {
    callAllAppenders(date,ReportLevel.WARNING, message);
  }

  @Override
  public void logError(String date, String message) {
    callAllAppenders(date,ReportLevel.ERROR, message);
  }

  @Override
  public void logCritical(String date, String message) {
    callAllAppenders(date,ReportLevel.CRITICAL, message);
  }

  @Override
  public void logFatal(String date, String message) {
    callAllAppenders(date,ReportLevel.FATAL, message);
  }

  @Override
  public void addAppender(Appender appender) {
    this.appenders.add(appender);
  }

  private void callAllAppenders(String date, ReportLevel reportLevel, String message) {
    for (Appender appender: appenders) {
      appender.append(date, reportLevel, message);
    }
  }
}

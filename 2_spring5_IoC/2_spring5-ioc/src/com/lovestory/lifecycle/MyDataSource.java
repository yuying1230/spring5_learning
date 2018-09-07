package com.lovestory.lifecycle;

// 模拟数据库连接池操作
public class MyDataSource {
	public MyDataSource() {
		System.out.println("my data source...");
	}
	
	public void open() {
		System.out.println("open resource...");
	}
	
	public void close() {
		System.out.println("close resource...");
	}
	
	public void doWork() {
		System.out.println("doWork...");
	}
}

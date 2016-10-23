package edu.psu.os.KV511.model;

import java.io.Serializable;

public class Message implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String instruction;
	private int key;
	private int value;
	
	public Message(String instruction, int key, int value) {
		super();
		this.instruction = instruction;
		this.key = key;
		this.value = value;
	}
	
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	public long getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public long getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return String.valueOf(key) + ":" + String.valueOf(value);
	}
	
}

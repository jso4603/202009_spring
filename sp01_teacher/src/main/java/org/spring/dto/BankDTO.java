package org.spring.dto;

public class BankDTO {
	private int seq;
	private int input;
	private int output;
	public BankDTO(int seq, int input, int output) {
		super();
		this.seq = seq;
		this.input = input;
		this.output = output;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getInput() {
		return input;
	}
	public void setInput(int input) {
		this.input = input;
	}
	public int getOutput() {
		return output;
	}
	public void setOutput(int output) {
		this.output = output;
	}
	@Override
	public String toString() {
		return "BankDTO [seq=" + seq + ", input=" + input + ", output=" + output + "]";
	}
	
}

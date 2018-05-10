package br.com.convertpdftohtml.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class WrappedBankSlipResponse implements Externalizable {

	private byte[] pdf;

	public WrappedBankSlipResponse() {}

	public WrappedBankSlipResponse(byte[] pdf) {
		this.pdf = pdf;
	}

	public byte[] getPdf() {
		return pdf;
	}

	public void setPdf(byte[] pdf) {
		this.pdf = pdf;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.write(pdf, 0, pdf.length);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		 in.readFully(pdf, 0, pdf.length);
	}
}

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
//		out.writeInt(pdf.length);
		out.write(pdf, 0, pdf.length);
//		out.writeInt(pdf.length);
//	    for (int i=0; i<pdf.length; i++) {
//	       out.writeInt(i);
//	       out.writeByte(pdf[i]);
//	    }
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		 in.readFully(pdf, 0, pdf.length);
//		 int len = in.readInt();
//		 pdf = new byte[len];
//	     for (int i=0; i<len; i++) {
//	        int index = in.readInt();
//	        pdf[index] = in.readByte();
//	        pdf[i] = in.readByte();
//	     }
	}
}

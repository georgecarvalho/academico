/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifma.formulario.model;

/**
 *
 * @author Carvalho
 */
import javax.swing.text.*;

public class LimitaNroCaracteres extends PlainDocument 
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -4981289439783419671L;
	private int iMaxLength;

    public LimitaNroCaracteres(int maxlen) {
        super();
        iMaxLength = maxlen;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr)
                    throws BadLocationException {
        //if (s == null) return;

        if (iMaxLength <= 0)        // aceitara qualquer no. de caracteres
        {
            super.insertString(offset, str, attr);
            return;
        }

        int ilen = (getLength() + str.length());
        if (ilen <= iMaxLength)    // se o comprimento final for menor...
            super.insertString(offset, str, attr);
        }

}

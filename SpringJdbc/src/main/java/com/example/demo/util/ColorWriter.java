package com.example.demo.util;

import org.fusesource.jansi.Ansi;
import org.springframework.stereotype.Component;

@Component
public class ColorWriter implements IColorWriter {

	@Override
	public String getColoredMessage(Color color, String mensaje) {
		return Ansi.ansi()//.eraseScreen()
				.render("@|" + color.getColor() + "    " + mensaje + "|@")
				.toString();
	}

}
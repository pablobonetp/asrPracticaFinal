package asr.proyectoFinal.services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.text_to_speech.v1.model.SynthesizeOptions;
import com.ibm.watson.text_to_speech.v1.util.WaveUtils;

public class Text2Speech 
{
	public static void text2speech(String audio)
	{
		IamAuthenticator authenticator = new IamAuthenticator("3oK6gtojZsmD0jCS2HGHFUBWb3v6Yv5meYFbNcuVBbjY");
		TextToSpeech textToSpeech = new TextToSpeech(authenticator);
		textToSpeech.setServiceUrl("https://api.eu-gb.text-to-speech.watson.cloud.ibm.com/instances/0d929505-c265-4e56-9a99-dfa5a2789baf");

		String text = "It's beginning to look a lot like Christmas";
		
		 try {
		       SynthesizeOptions synthesizeOptions =
		       new SynthesizeOptions.Builder()
		         .text(text)
		         .accept("audio/wav")
		         .voice("en-US_AllisonV3Voice")
		         .build();

		       InputStream inputStream =
		       textToSpeech.synthesize(synthesizeOptions).execute().getResult();
		       InputStream in = WaveUtils.reWriteWaveHeader(inputStream);

		       OutputStream out = new FileOutputStream("/Users/pablobonet/" + audio + ".wav");
		       byte[] buffer = new byte[1024];
		       int length;
		       while ((length = in.read(buffer)) > 0) {
		       out.write(buffer, 0, length);
		       }

		       out.close();
		       in.close();
		       inputStream.close();
		      } catch (IOException e) {
		        e.printStackTrace();
		      }
	}
}

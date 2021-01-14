package asr.proyectoFinal.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.text_to_speech.v1.model.SynthesizeOptions;
import com.ibm.watson.text_to_speech.v1.util.WaveUtils;

public class Text2Speech 
{
	public static void text2speech(String text, String audio)
	{
		IamAuthenticator authenticator = new IamAuthenticator("JgGHK2SduTgOhjmztMxgF7thJpb0lj9oI5evD4Wsr6oq");
		TextToSpeech textToSpeech = new TextToSpeech(authenticator);
		textToSpeech.setServiceUrl("https://api.eu-gb.text-to-speech.watson.cloud.ibm.com/instances/235774ea-1f98-450f-899d-f441e9e93fc5");

		//String text = "It's beginning to look a lot like Christmas";
		
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

		       OutputStream out = new FileOutputStream("/Users/pablobonet/Desktop/" + audio + ".wav");
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
	
	public static void play(String audio)
	{
		try 
		{
			AudioInputStream a = AudioSystem.getAudioInputStream(new File("/Desktop/" + audio + ".wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(a);
			clip.start();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

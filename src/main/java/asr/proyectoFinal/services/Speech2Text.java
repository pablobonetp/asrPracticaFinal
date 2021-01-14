package asr.proyectoFinal.services;

import java.io.File;
import java.io.FileNotFoundException;

import com.ibm.cloud.sdk.core.http.HttpMediaType;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.speech_to_text.v1.SpeechToText;
import com.ibm.watson.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.speech_to_text.v1.model.SpeechRecognitionResults;

public class Speech2Text 
{	
	public static String speech2text(String archivo) throws FileNotFoundException
	{
	IamAuthenticator authenticator = new IamAuthenticator("3BFOe63D_BNhI5EM4f7YTCuble2RCZ84fzGjg1ekhuKS");
	SpeechToText service = new SpeechToText(authenticator);
	service.setServiceUrl("https://api.eu-gb.speech-to-text.watson.cloud.ibm.com/instances/dc7024bf-392b-4204-a13a-c46bb1475079");

	File audio = new File("/Users/pablobonet/Desktop/"+ archivo + ".wav");

	RecognizeOptions options = new RecognizeOptions.Builder()
	  .audio(audio)
	  .contentType(HttpMediaType.AUDIO_WAV)
	  .build();

	SpeechRecognitionResults transcript = service.recognize(options).execute().getResult();
	return transcript.toString();
	//System.out.println(transcript);
	}
}

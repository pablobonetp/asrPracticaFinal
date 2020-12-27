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
	public static void speech2text() throws FileNotFoundException
	{
	IamAuthenticator authenticator = new IamAuthenticator("g1yAexLNcrsTOD5dOrSQt8sVbwO-k0x5z1VNPfU87ig0");
	SpeechToText service = new SpeechToText(authenticator);
	service.setServiceUrl("https://api.eu-gb.speech-to-text.watson.cloud.ibm.com/instances/3889ba61-3321-4bf0-bf97-0208c2b7b62a");

	File audio = new File("/Users/pablobonet/sample1.wav");

	RecognizeOptions options = new RecognizeOptions.Builder()
	  .audio(audio)
	  .contentType(HttpMediaType.AUDIO_WAV)
	  .build();

	SpeechRecognitionResults transcript = service.recognize(options).execute().getResult();
	System.out.println(transcript);
	}
}

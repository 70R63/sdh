/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import de.hybris.sdh.facades.questions.data.OptionsData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * @author Consultor
 *
 */
public class QuestionForRegistrationResponse
{
	private String idmsj;
	private String txtmsj;
	private List<QuestionResponse> preguntas;
	private List<QuestionCatalog> catalogo;

	private final Map<String, String> mapQuestionsCatalog = new HashMap<>();
	private Map<String, List<QuestionResponse>> mapQuestions = new HashMap<>();

	/**
	 * @return the idmsj
	 */
	public String getIdmsj()
	{
		return idmsj;
	}

	/**
	 * @param idmsj
	 *           the idmsj to set
	 */
	public void setIdmsj(final String idmsj)
	{
		this.idmsj = idmsj;
	}

	/**
	 * @return the txtmsj
	 */
	public String getTxtmsj()
	{
		return txtmsj;
	}

	/**
	 * @param txtmsj
	 *           the txtmsj to set
	 */
	public void setTxtmsj(final String txtmsj)
	{
		this.txtmsj = txtmsj;
	}

	/**
	 * @return the questions
	 */

	/**
	 * @return the preguntas
	 */
	public List<QuestionResponse> getPreguntas()
	{
		return preguntas;
	}

	/**
	 * @param preguntas
	 *           the preguntas to set
	 */
	public void setPreguntas(final List<QuestionResponse> preguntas)
	{
		this.preguntas = preguntas;
		this.mapQuestions = preguntas.stream().collect(Collectors.groupingBy(QuestionResponse::getIdPreg));
	}


	/**
	 * @return the catalogo
	 */
	public List<QuestionCatalog> getCatalogo()
	{
		return catalogo;
	}

	/**
	 * @param catalogo
	 *           the catalogo to set
	 */
	public void setCatalogo(final List<QuestionCatalog> catalogo)
	{
		this.catalogo = catalogo;
		for (final QuestionCatalog question : catalogo)
		{
			this.mapQuestionsCatalog.put(question.getIdPreg(), question.getTextoPreg());
		}
	}

	/**
	 * @return the mapQuestions
	 */
	public Map<String, List<QuestionResponse>> getMapQuestions()
	{
		return mapQuestions;
	}

	/**
	 * @param mapQuestions
	 *           the mapQuestions to set
	 */
	public void setMapQuestions(final Map<String, List<QuestionResponse>> mapQuestions)
	{
		this.mapQuestions = mapQuestions;
	}

	/**
	 * @return the mapQuestionsCatalog
	 */
	public Map<String, String> getMapQuestionsCatalog()
	{
		return mapQuestionsCatalog;
	}

	/* No en uso */
	public List<QuestionResponse> getAnswersByQuestionIndex(final int index)
	{
		if (index < this.mapQuestions.size())
		{
			return this.mapQuestions.get((this.mapQuestions.keySet().toArray())[index]);
		}

		return null;
	}

	public Map<String, Collection<OptionsData>> getQuestionAndOptions()
	{
		final Map<String, Collection<OptionsData>> questionsAndOptions = new HashMap<>();
		final Map<String, List<QuestionResponse>> questionAndOptions = this.getMapQuestions();

		final List keys = new ArrayList(questionAndOptions.keySet());
		Collections.shuffle(Objects.isNull(keys) ? new ArrayList<String>() : keys); //Shuffling List
		final List<String> subListKeys = keys.subList(0, 5); //Getting just the first 5 elements

		for (final String strKey : subListKeys)
		{
			final Collection<OptionsData> optionsDataSelect = new ArrayList<>();
			for (final QuestionResponse options : questionAndOptions.get(strKey))
			{
				final OptionsData option = new OptionsData();
				option.setCode(options.getConsecutivo());
				option.setName(options.getTextoResp());
				optionsDataSelect.add(option);
			}
			questionsAndOptions.put(strKey, optionsDataSelect);
		}

		/*
		 * for (final Map.Entry<String, List<QuestionResponse>> entry : questionAndOptions.entrySet()) { final
		 * Collection<OptionsData> optionsDataSelect = new ArrayList<>();
		 *
		 * for (final QuestionResponse options : entry.getValue()) { final OptionsData option = new OptionsData();
		 * option.setCode(options.getConsecutivo()); option.setName(options.getTextoResp());
		 *
		 * optionsDataSelect.add(option); }
		 *
		 * questionsAndOptions.put(entry.getKey(), optionsDataSelect); }
		 */



		return questionsAndOptions;
	}

	public String getCorrectAnswer(final String idPreg)
	{
		String correctAnswer = "";

		if(this.getMapQuestions() != null) {
			if(this.getMapQuestions().get(idPreg) != null) {
			for(final QuestionResponse option : this.getMapQuestions().get(idPreg)) {
				if(option != null) {
					//if(option.getIndicador() != null) {
						if(option.getIndicador().equals("X")) {
							correctAnswer = option.getConsecutivo();
						}
					//}
				}
			}
		}
		}

		return correctAnswer;
	}

	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("\"questionForRegistration\":{");
		stringBuilder.append("\"idmsj\":\"" + this.getIdmsj() + "\",");
		stringBuilder.append("\"txtmsj\":\"" + this.getTxtmsj() + "\",");
		stringBuilder.append("\"questions\":\"" + this.getPreguntas().toString() + "\",");
		stringBuilder.append("\"catalogo\":\"" + this.getCatalogo().toString() + "\",");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}



}

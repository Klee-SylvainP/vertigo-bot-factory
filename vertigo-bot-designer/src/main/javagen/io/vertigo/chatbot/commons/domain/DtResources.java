package io.vertigo.chatbot.commons.domain;

import io.vertigo.core.locale.MessageKey;

/**
 * Attention cette classe est générée automatiquement !
 * Resources du module io.vertigo.chatbot.commons.domain
 */
public enum DtResources implements MessageKey {

	/***********************************************************
	/** BotExport.
	/***********************************************************
	/**
	 * chatbot.
	 */
	fldBotExport$bot,
	/**
	 * welcome BT.
	 */
	fldBotExport$welcomeBT,
	/**
	 * fallback BT.
	 */
	fldBotExport$fallbackBT,
	/**
	 * fallback BT.
	 */
	fldBotExport$topics,

	/***********************************************************
	/** Chatbot.
	/***********************************************************
	/**
	 * ID.
	 */
	fldChatbot$botId,
	/**
	 * Name.
	 */
	fldChatbot$name,
	/**
	 * Description.
	 */
	fldChatbot$description,
	/**
	 * Creation date.
	 */
	fldChatbot$creationDate,
	/**
	 * Status.
	 */
	fldChatbot$status,
	/**
	 * Avatar.
	 */
	fldChatbot$filIdAvatar,
	/**
	 * Welcome text.
	 */
	fldChatbot$uttIdWelcome,
	/**
	 * Default text.
	 */
	fldChatbot$uttIdDefault,

	/***********************************************************
	/** ChatbotNode.
	/***********************************************************
	/**
	 * ID.
	 */
	fldChatbotNode$nodId,
	/**
	 * Name.
	 */
	fldChatbotNode$name,
	/**
	 * URL.
	 */
	fldChatbotNode$url,
	/**
	 * Dev node.
	 */
	fldChatbotNode$isDev,
	/**
	 * Color.
	 */
	fldChatbotNode$color,
	/**
	 * ApiKey.
	 */
	fldChatbotNode$apiKey,
	/**
	 * Chatbot.
	 */
	fldChatbotNode$botId,
	/**
	 * Loaded model.
	 */
	fldChatbotNode$traId,

	/***********************************************************
	/** ExecutorConfiguration.
	/***********************************************************
	/**
	 * Bot ID.
	 */
	fldExecutorConfiguration$botId,
	/**
	 * Node ID.
	 */
	fldExecutorConfiguration$nodId,
	/**
	 * Model ID.
	 */
	fldExecutorConfiguration$traId,
	/**
	 * Model name.
	 */
	fldExecutorConfiguration$modelName,
	/**
	 * NLU Threshold.
	 */
	fldExecutorConfiguration$nluThreshold,
	/**
	 * Additional config for executor.
	 */
	fldExecutorConfiguration$customConfig,

	/***********************************************************
	/** ExecutorTrainingCallback.
	/***********************************************************
	/**
	 * Training ID.
	 */
	fldExecutorTrainingCallback$trainingId,
	/**
	 * Succes.
	 */
	fldExecutorTrainingCallback$success,
	/**
	 * Logs.
	 */
	fldExecutorTrainingCallback$log,
	/**
	 * Informations.
	 */
	fldExecutorTrainingCallback$infos,
	/**
	 * Warnings.
	 */
	fldExecutorTrainingCallback$warnings,
	/**
	 * Client Api Key.
	 */
	fldExecutorTrainingCallback$apiKey,

	/***********************************************************
	/** MediaFileInfo.
	/***********************************************************
	/**
	 * Id.
	 */
	fldMediaFileInfo$filId,
	/**
	 * Name.
	 */
	fldMediaFileInfo$fileName,
	/**
	 * MimeType.
	 */
	fldMediaFileInfo$mimeType,
	/**
	 * Size.
	 */
	fldMediaFileInfo$length,
	/**
	 * Modification Date.
	 */
	fldMediaFileInfo$lastModified,
	/**
	 * path.
	 */
	fldMediaFileInfo$filePath,
	/**
	 * data.
	 */
	fldMediaFileInfo$fileData,

	/***********************************************************
	/** NluTrainingSentence.
	/***********************************************************
	/**
	 * ID.
	 */
	fldNluTrainingSentence$ntsId,
	/**
	 * Text.
	 */
	fldNluTrainingSentence$text,
	/**
	 * SmallTalk.
	 */
	fldNluTrainingSentence$smtId,

	/***********************************************************
	/** ResponseButton.
	/***********************************************************
	/**
	 * ID.
	 */
	fldResponseButton$btnId,
	/**
	 * Text.
	 */
	fldResponseButton$text,
	/**
	 * SmallTalk.
	 */
	fldResponseButton$smtId,
	/**
	 * SmallTalkResponse.
	 */
	fldResponseButton$smtIdResponse,
	/**
	 * welcome buttons.
	 */
	fldResponseButton$botIdWelcome,
	/**
	 * Default buttons.
	 */
	fldResponseButton$botIdDefault,

	/***********************************************************
	/** ResponseType.
	/***********************************************************
	/**
	 * ID.
	 */
	fldResponseType$rtyId,
	/**
	 * Title.
	 */
	fldResponseType$label,
	/**
	 * TitleFr.
	 */
	fldResponseType$labelFr,
	/**
	 * Order.
	 */
	fldResponseType$sortOrder,

	/***********************************************************
	/** RunnerInfo.
	/***********************************************************
	/**
	 * Name.
	 */
	fldRunnerInfo$name,
	/**
	 * Node state.
	 */
	fldRunnerInfo$state,
	/**
	 * Component version.
	 */
	fldRunnerInfo$agentVersion,
	/**
	 * Model version.
	 */
	fldRunnerInfo$loadedModelVersion,

	/***********************************************************
	/** SmallTalk.
	/***********************************************************
	/**
	 * ID.
	 */
	fldSmallTalk$smtId,
	/**
	 * Title.
	 */
	fldSmallTalk$title,
	/**
	 * Description.
	 */
	fldSmallTalk$description,
	/**
	 * Enabled.
	 */
	fldSmallTalk$isEnabled,
	/**
	 * Chatbot.
	 */
	fldSmallTalk$botId,
	/**
	 * Response type.
	 */
	fldSmallTalk$rtyId,

	/***********************************************************
	/** TopicExport.
	/***********************************************************
	/**
	 * Topic name.
	 */
	fldTopicExport$name,
	/**
	 * nluTrainingSentences.
	 */
	fldTopicExport$nluTrainingSentences,
	/**
	 * Topic BT.
	 */
	fldTopicExport$topicBT,

	/***********************************************************
	/** TrainerInfo.
	/***********************************************************
	/**
	 * Name.
	 */
	fldTrainerInfo$name,
	/**
	 * Training in progress.
	 */
	fldTrainerInfo$trainingInProgress,
	/**
	 * Training state.
	 */
	fldTrainerInfo$trainingState,
	/**
	 * Training log.
	 */
	fldTrainerInfo$latestTrainingLog,
	/**
	 * Start time.
	 */
	fldTrainerInfo$startTime,
	/**
	 * End time.
	 */
	fldTrainerInfo$endTime,
	/**
	 * Training percentage.
	 */
	fldTrainerInfo$trainingPercent,
	/**
	 * Duration.
	 */
	fldTrainerInfo$duration,

	/***********************************************************
	/** Training.
	/***********************************************************
	/**
	 * ID.
	 */
	fldTraining$traId,
	/**
	 * Start time.
	 */
	fldTraining$startTime,
	/**
	 * End time.
	 */
	fldTraining$endTime,
	/**
	 * Version.
	 */
	fldTraining$versionNumber,
	/**
	 * Status.
	 */
	fldTraining$status,
	/**
	 * Log.
	 */
	fldTraining$log,
	/**
	 * Informations.
	 */
	fldTraining$infos,
	/**
	 * Warnings.
	 */
	fldTraining$warnings,
	/**
	 * NLU Threshold.
	 */
	fldTraining$nluThreshold,
	/**
	 * Duration.
	 */
	fldTraining$duration,
	/**
	 * Chatbot.
	 */
	fldTraining$botId,
	/**
	 * Model.
	 */
	fldTraining$filIdModel,

	/***********************************************************
	/** UtterText.
	/***********************************************************
	/**
	 * ID.
	 */
	fldUtterText$uttId,
	/**
	 * Text.
	 */
	fldUtterText$text,
	/**
	 * SmallTalk.
	 */
	fldUtterText$smtId,
}

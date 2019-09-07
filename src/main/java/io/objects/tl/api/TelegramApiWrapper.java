package io.objects.tl.api;

import static io.objects.tl.StreamUtils.*;
import static io.objects.tl.TLObjectUtils.*;

import io.objects.tl.api.account.TLAuthorizationForm;
import io.objects.tl.api.account.TLAuthorizations;
import io.objects.tl.api.account.TLPassword;
import io.objects.tl.api.account.TLPasswordInputSettings;
import io.objects.tl.api.account.TLPasswordSettings;
import io.objects.tl.api.account.TLPrivacyRules;
import io.objects.tl.api.account.TLSentEmailCode;
import io.objects.tl.api.account.TLTakeout;
import io.objects.tl.api.account.TLTmpPassword;
import io.objects.tl.api.account.TLWebAuthorizations;
import io.objects.tl.api.auth.TLAuthorization;
import io.objects.tl.api.auth.TLExportedAuthorization;
import io.objects.tl.api.auth.TLPasswordRecovery;
import io.objects.tl.api.auth.TLSentCode;
import io.objects.tl.api.channels.TLAbsChannelParticipants;
import io.objects.tl.api.channels.TLAdminLogResults;
import io.objects.tl.api.channels.TLChannelParticipant;
import io.objects.tl.api.contacts.TLAbsBlocked;
import io.objects.tl.api.contacts.TLAbsContacts;
import io.objects.tl.api.contacts.TLAbsTopPeers;
import io.objects.tl.api.contacts.TLFound;
import io.objects.tl.api.contacts.TLImportedContacts;
import io.objects.tl.api.contacts.TLLink;
import io.objects.tl.api.contacts.TLResolvedPeer;
import io.objects.tl.api.help.TLAbsAppUpdate;
import io.objects.tl.api.help.TLAbsDeepLinkInfo;
import io.objects.tl.api.help.TLAbsPassportConfig;
import io.objects.tl.api.help.TLAbsProxyData;
import io.objects.tl.api.help.TLAbsTermsOfServiceUpdate;
import io.objects.tl.api.help.TLInviteText;
import io.objects.tl.api.help.TLRecentMeUrls;
import io.objects.tl.api.help.TLSupport;
import io.objects.tl.api.messages.TLAbsAllStickers;
import io.objects.tl.api.messages.TLAbsChats;
import io.objects.tl.api.messages.TLAbsDhConfig;
import io.objects.tl.api.messages.TLAbsDialogs;
import io.objects.tl.api.messages.TLAbsFavedStickers;
import io.objects.tl.api.messages.TLAbsFeaturedStickers;
import io.objects.tl.api.messages.TLAbsFoundStickerSets;
import io.objects.tl.api.messages.TLAbsMessages;
import io.objects.tl.api.messages.TLAbsRecentStickers;
import io.objects.tl.api.messages.TLAbsSavedGifs;
import io.objects.tl.api.messages.TLAbsSentEncryptedMessage;
import io.objects.tl.api.messages.TLAbsStickerSetInstallResult;
import io.objects.tl.api.messages.TLAbsStickers;
import io.objects.tl.api.messages.TLAffectedHistory;
import io.objects.tl.api.messages.TLAffectedMessages;
import io.objects.tl.api.messages.TLArchivedStickers;
import io.objects.tl.api.messages.TLBotCallbackAnswer;
import io.objects.tl.api.messages.TLBotResults;
import io.objects.tl.api.messages.TLChatFull;
import io.objects.tl.api.messages.TLFoundGifs;
import io.objects.tl.api.messages.TLHighScores;
import io.objects.tl.api.messages.TLMessageEditData;
import io.objects.tl.api.messages.TLPeerDialogs;
import io.objects.tl.api.messages.TLStickerSet;
import io.objects.tl.api.monobot.TLBotFile;
import io.objects.tl.api.payments.TLAbsPaymentResult;
import io.objects.tl.api.payments.TLPaymentForm;
import io.objects.tl.api.payments.TLPaymentReceipt;
import io.objects.tl.api.payments.TLSavedInfo;
import io.objects.tl.api.payments.TLValidatedRequestedInfo;
import io.objects.tl.api.phone.TLPhoneCall;
import io.objects.tl.api.photos.TLAbsPhotos;
import io.objects.tl.api.photos.TLPhoto;
import io.objects.tl.api.request.TLRequestAccountAcceptAuthorization;
import io.objects.tl.api.request.TLRequestAccountChangePhone;
import io.objects.tl.api.request.TLRequestAccountCheckUsername;
import io.objects.tl.api.request.TLRequestAccountConfirmPhone;
import io.objects.tl.api.request.TLRequestAccountDeleteAccount;
import io.objects.tl.api.request.TLRequestAccountDeleteSecureValue;
import io.objects.tl.api.request.TLRequestAccountFinishTakeoutSession;
import io.objects.tl.api.request.TLRequestAccountGetAccountTTL;
import io.objects.tl.api.request.TLRequestAccountGetAllSecureValues;
import io.objects.tl.api.request.TLRequestAccountGetAuthorizationForm;
import io.objects.tl.api.request.TLRequestAccountGetAuthorizations;
import io.objects.tl.api.request.TLRequestAccountGetNotifySettings;
import io.objects.tl.api.request.TLRequestAccountGetPassword;
import io.objects.tl.api.request.TLRequestAccountGetPasswordSettings;
import io.objects.tl.api.request.TLRequestAccountGetPrivacy;
import io.objects.tl.api.request.TLRequestAccountGetSecureValue;
import io.objects.tl.api.request.TLRequestAccountGetTmpPassword;
import io.objects.tl.api.request.TLRequestAccountGetWallPapers;
import io.objects.tl.api.request.TLRequestAccountGetWebAuthorizations;
import io.objects.tl.api.request.TLRequestAccountInitTakeoutSession;
import io.objects.tl.api.request.TLRequestAccountRegisterDevice;
import io.objects.tl.api.request.TLRequestAccountRegisterDeviceV71;
import io.objects.tl.api.request.TLRequestAccountReportPeer;
import io.objects.tl.api.request.TLRequestAccountResetAuthorization;
import io.objects.tl.api.request.TLRequestAccountResetNotifySettings;
import io.objects.tl.api.request.TLRequestAccountResetWebAuthorization;
import io.objects.tl.api.request.TLRequestAccountResetWebAuthorizations;
import io.objects.tl.api.request.TLRequestAccountSaveSecureValue;
import io.objects.tl.api.request.TLRequestAccountSendChangePhoneCode;
import io.objects.tl.api.request.TLRequestAccountSendConfirmPhoneCode;
import io.objects.tl.api.request.TLRequestAccountSendVerifyEmailCode;
import io.objects.tl.api.request.TLRequestAccountSendVerifyPhoneCode;
import io.objects.tl.api.request.TLRequestAccountSetAccountTTL;
import io.objects.tl.api.request.TLRequestAccountSetPrivacy;
import io.objects.tl.api.request.TLRequestAccountUnregisterDevice;
import io.objects.tl.api.request.TLRequestAccountUpdateDeviceLocked;
import io.objects.tl.api.request.TLRequestAccountUpdateNotifySettings;
import io.objects.tl.api.request.TLRequestAccountUpdatePasswordSettings;
import io.objects.tl.api.request.TLRequestAccountUpdateProfile;
import io.objects.tl.api.request.TLRequestAccountUpdateStatus;
import io.objects.tl.api.request.TLRequestAccountUpdateUsername;
import io.objects.tl.api.request.TLRequestAccountVerifyEmail;
import io.objects.tl.api.request.TLRequestAccountVerifyPhone;
import io.objects.tl.api.request.TLRequestAuthBindTempAuthKey;
import io.objects.tl.api.request.TLRequestAuthCancelCode;
import io.objects.tl.api.request.TLRequestAuthCheckPassword;
import io.objects.tl.api.request.TLRequestAuthDropTempAuthKeys;
import io.objects.tl.api.request.TLRequestAuthExportAuthorization;
import io.objects.tl.api.request.TLRequestAuthImportAuthorization;
import io.objects.tl.api.request.TLRequestAuthImportBotAuthorization;
import io.objects.tl.api.request.TLRequestAuthLogOut;
import io.objects.tl.api.request.TLRequestAuthRecoverPassword;
import io.objects.tl.api.request.TLRequestAuthRequestPasswordRecovery;
import io.objects.tl.api.request.TLRequestAuthResendCode;
import io.objects.tl.api.request.TLRequestAuthResetAuthorizations;
import io.objects.tl.api.request.TLRequestAuthSendCode;
import io.objects.tl.api.request.TLRequestAuthSignIn;
import io.objects.tl.api.request.TLRequestAuthSignUp;
import io.objects.tl.api.request.TLRequestBotsAnswerWebhookJSONQuery;
import io.objects.tl.api.request.TLRequestBotsSendCustomRequest;
import io.objects.tl.api.request.TLRequestChannelGetMessagesV71;
import io.objects.tl.api.request.TLRequestChannelsCheckUsername;
import io.objects.tl.api.request.TLRequestChannelsCreateChannel;
import io.objects.tl.api.request.TLRequestChannelsDeleteChannel;
import io.objects.tl.api.request.TLRequestChannelsDeleteHistory;
import io.objects.tl.api.request.TLRequestChannelsDeleteMessages;
import io.objects.tl.api.request.TLRequestChannelsDeleteUserHistory;
import io.objects.tl.api.request.TLRequestChannelsEditAbout;
import io.objects.tl.api.request.TLRequestChannelsEditAdmin;
import io.objects.tl.api.request.TLRequestChannelsEditBanned;
import io.objects.tl.api.request.TLRequestChannelsEditPhoto;
import io.objects.tl.api.request.TLRequestChannelsEditTitle;
import io.objects.tl.api.request.TLRequestChannelsExportInvite;
import io.objects.tl.api.request.TLRequestChannelsExportMessageLink;
import io.objects.tl.api.request.TLRequestChannelsGetAdminLog;
import io.objects.tl.api.request.TLRequestChannelsGetAdminedPublicChannels;
import io.objects.tl.api.request.TLRequestChannelsGetChannels;
import io.objects.tl.api.request.TLRequestChannelsGetFullChannel;
import io.objects.tl.api.request.TLRequestChannelsGetLeftChannels;
import io.objects.tl.api.request.TLRequestChannelsGetMessages;
import io.objects.tl.api.request.TLRequestChannelsGetParticipant;
import io.objects.tl.api.request.TLRequestChannelsGetParticipants;
import io.objects.tl.api.request.TLRequestChannelsInviteToChannel;
import io.objects.tl.api.request.TLRequestChannelsJoinChannel;
import io.objects.tl.api.request.TLRequestChannelsLeaveChannel;
import io.objects.tl.api.request.TLRequestChannelsReadHistory;
import io.objects.tl.api.request.TLRequestChannelsReadMessageContents;
import io.objects.tl.api.request.TLRequestChannelsReportSpam;
import io.objects.tl.api.request.TLRequestChannelsSetStickers;
import io.objects.tl.api.request.TLRequestChannelsToggleInvites;
import io.objects.tl.api.request.TLRequestChannelsTogglePreHistoryHidden;
import io.objects.tl.api.request.TLRequestChannelsToggleSignatures;
import io.objects.tl.api.request.TLRequestChannelsUpdatePinnedMessage;
import io.objects.tl.api.request.TLRequestChannelsUpdateUsername;
import io.objects.tl.api.request.TLRequestContactsBlock;
import io.objects.tl.api.request.TLRequestContactsDeleteContact;
import io.objects.tl.api.request.TLRequestContactsDeleteContacts;
import io.objects.tl.api.request.TLRequestContactsExportCard;
import io.objects.tl.api.request.TLRequestContactsGetBlocked;
import io.objects.tl.api.request.TLRequestContactsGetContacts;
import io.objects.tl.api.request.TLRequestContactsGetSaved;
import io.objects.tl.api.request.TLRequestContactsGetStatuses;
import io.objects.tl.api.request.TLRequestContactsGetTopPeers;
import io.objects.tl.api.request.TLRequestContactsImportCard;
import io.objects.tl.api.request.TLRequestContactsImportContacts;
import io.objects.tl.api.request.TLRequestContactsResetSaved;
import io.objects.tl.api.request.TLRequestContactsResetTopPeerRating;
import io.objects.tl.api.request.TLRequestContactsResolveUsername;
import io.objects.tl.api.request.TLRequestContactsSearch;
import io.objects.tl.api.request.TLRequestContactsToggleTopPeers;
import io.objects.tl.api.request.TLRequestContactsUnblock;
import io.objects.tl.api.request.TLRequestHelpAcceptTermsOfService;
import io.objects.tl.api.request.TLRequestHelpGetAppChangelog;
import io.objects.tl.api.request.TLRequestHelpGetAppUpdate;
import io.objects.tl.api.request.TLRequestHelpGetCdnConfig;
import io.objects.tl.api.request.TLRequestHelpGetConfig;
import io.objects.tl.api.request.TLRequestHelpGetDeepLinkInfo;
import io.objects.tl.api.request.TLRequestHelpGetInviteText;
import io.objects.tl.api.request.TLRequestHelpGetNearestDc;
import io.objects.tl.api.request.TLRequestHelpGetPassportConfig;
import io.objects.tl.api.request.TLRequestHelpGetProxyData;
import io.objects.tl.api.request.TLRequestHelpGetRecentMeUrls;
import io.objects.tl.api.request.TLRequestHelpGetSupport;
import io.objects.tl.api.request.TLRequestHelpSaveAppLog;
import io.objects.tl.api.request.TLRequestHelpSetBotUpdatesStatus;
import io.objects.tl.api.request.TLRequestInitConnection;
import io.objects.tl.api.request.TLRequestInvokeAfterMsg;
import io.objects.tl.api.request.TLRequestInvokeAfterMsgs;
import io.objects.tl.api.request.TLRequestInvokeWithLayer;
import io.objects.tl.api.request.TLRequestInvokeWithMessagesRange;
import io.objects.tl.api.request.TLRequestInvokeWithTakeout;
import io.objects.tl.api.request.TLRequestInvokeWithoutUpdates;
import io.objects.tl.api.request.TLRequestLangpackGetDifference;
import io.objects.tl.api.request.TLRequestLangpackGetLangPack;
import io.objects.tl.api.request.TLRequestLangpackGetLanguages;
import io.objects.tl.api.request.TLRequestLangpackGetStrings;
import io.objects.tl.api.request.TLRequestMessagesAcceptEncryption;
import io.objects.tl.api.request.TLRequestMessagesAddChatUser;
import io.objects.tl.api.request.TLRequestMessagesCheckChatInvite;
import io.objects.tl.api.request.TLRequestMessagesClearAllDrafts;
import io.objects.tl.api.request.TLRequestMessagesClearRecentStickers;
import io.objects.tl.api.request.TLRequestMessagesCreateChat;
import io.objects.tl.api.request.TLRequestMessagesDeleteChatUser;
import io.objects.tl.api.request.TLRequestMessagesDeleteHistory;
import io.objects.tl.api.request.TLRequestMessagesDeleteMessages;
import io.objects.tl.api.request.TLRequestMessagesDiscardEncryption;
import io.objects.tl.api.request.TLRequestMessagesEditChatAdmin;
import io.objects.tl.api.request.TLRequestMessagesEditChatPhoto;
import io.objects.tl.api.request.TLRequestMessagesEditChatTitle;
import io.objects.tl.api.request.TLRequestMessagesEditInlineBotMessage;
import io.objects.tl.api.request.TLRequestMessagesEditMessage;
import io.objects.tl.api.request.TLRequestMessagesExportChatInvite;
import io.objects.tl.api.request.TLRequestMessagesFaveSticker;
import io.objects.tl.api.request.TLRequestMessagesForwardMessages;
import io.objects.tl.api.request.TLRequestMessagesGetAllChats;
import io.objects.tl.api.request.TLRequestMessagesGetAllDrafts;
import io.objects.tl.api.request.TLRequestMessagesGetAllStickers;
import io.objects.tl.api.request.TLRequestMessagesGetArchivedStickers;
import io.objects.tl.api.request.TLRequestMessagesGetAttachedStickers;
import io.objects.tl.api.request.TLRequestMessagesGetBotCallbackAnswer;
import io.objects.tl.api.request.TLRequestMessagesGetChats;
import io.objects.tl.api.request.TLRequestMessagesGetCommonChats;
import io.objects.tl.api.request.TLRequestMessagesGetDhConfig;
import io.objects.tl.api.request.TLRequestMessagesGetDialogUnreadMarks;
import io.objects.tl.api.request.TLRequestMessagesGetDialogs;
import io.objects.tl.api.request.TLRequestMessagesGetDocumentByHash;
import io.objects.tl.api.request.TLRequestMessagesGetFavedStickers;
import io.objects.tl.api.request.TLRequestMessagesGetFeaturedStickers;
import io.objects.tl.api.request.TLRequestMessagesGetFullChat;
import io.objects.tl.api.request.TLRequestMessagesGetGameHighScores;
import io.objects.tl.api.request.TLRequestMessagesGetHistory;
import io.objects.tl.api.request.TLRequestMessagesGetHistoryV71;
import io.objects.tl.api.request.TLRequestMessagesGetInlineBotResults;
import io.objects.tl.api.request.TLRequestMessagesGetInlineGameHighScores;
import io.objects.tl.api.request.TLRequestMessagesGetMaskStickers;
import io.objects.tl.api.request.TLRequestMessagesGetMessageEditData;
import io.objects.tl.api.request.TLRequestMessagesGetMessages;
import io.objects.tl.api.request.TLRequestMessagesGetMessagesV71;
import io.objects.tl.api.request.TLRequestMessagesGetMessagesViews;
import io.objects.tl.api.request.TLRequestMessagesGetPeerDialogs;
import io.objects.tl.api.request.TLRequestMessagesGetPeerSettings;
import io.objects.tl.api.request.TLRequestMessagesGetPinnedDialogs;
import io.objects.tl.api.request.TLRequestMessagesGetRecentLocations;
import io.objects.tl.api.request.TLRequestMessagesGetRecentStickers;
import io.objects.tl.api.request.TLRequestMessagesGetSavedGifs;
import io.objects.tl.api.request.TLRequestMessagesGetSplitRanges;
import io.objects.tl.api.request.TLRequestMessagesGetStickerSet;
import io.objects.tl.api.request.TLRequestMessagesGetStickers;
import io.objects.tl.api.request.TLRequestMessagesGetUnreadMentions;
import io.objects.tl.api.request.TLRequestMessagesGetWebPage;
import io.objects.tl.api.request.TLRequestMessagesGetWebPagePreview;
import io.objects.tl.api.request.TLRequestMessagesHideReportSpam;
import io.objects.tl.api.request.TLRequestMessagesImportChatInvite;
import io.objects.tl.api.request.TLRequestMessagesInstallStickerSet;
import io.objects.tl.api.request.TLRequestMessagesMarkDialogUnread;
import io.objects.tl.api.request.TLRequestMessagesMigrateChat;
import io.objects.tl.api.request.TLRequestMessagesReadEncryptedHistory;
import io.objects.tl.api.request.TLRequestMessagesReadFeaturedStickers;
import io.objects.tl.api.request.TLRequestMessagesReadHistory;
import io.objects.tl.api.request.TLRequestMessagesReadMentions;
import io.objects.tl.api.request.TLRequestMessagesReadMessageContents;
import io.objects.tl.api.request.TLRequestMessagesReceivedMessages;
import io.objects.tl.api.request.TLRequestMessagesReceivedQueue;
import io.objects.tl.api.request.TLRequestMessagesReorderPinnedDialogs;
import io.objects.tl.api.request.TLRequestMessagesReorderStickerSets;
import io.objects.tl.api.request.TLRequestMessagesReport;
import io.objects.tl.api.request.TLRequestMessagesReportEncryptedSpam;
import io.objects.tl.api.request.TLRequestMessagesReportSpam;
import io.objects.tl.api.request.TLRequestMessagesRequestEncryption;
import io.objects.tl.api.request.TLRequestMessagesSaveDraft;
import io.objects.tl.api.request.TLRequestMessagesSaveGif;
import io.objects.tl.api.request.TLRequestMessagesSaveRecentSticker;
import io.objects.tl.api.request.TLRequestMessagesSearch;
import io.objects.tl.api.request.TLRequestMessagesSearchGifs;
import io.objects.tl.api.request.TLRequestMessagesSearchGlobal;
import io.objects.tl.api.request.TLRequestMessagesSearchStickerSets;
import io.objects.tl.api.request.TLRequestMessagesSendEncrypted;
import io.objects.tl.api.request.TLRequestMessagesSendEncryptedFile;
import io.objects.tl.api.request.TLRequestMessagesSendEncryptedService;
import io.objects.tl.api.request.TLRequestMessagesSendInlineBotResult;
import io.objects.tl.api.request.TLRequestMessagesSendMedia;
import io.objects.tl.api.request.TLRequestMessagesSendMessage;
import io.objects.tl.api.request.TLRequestMessagesSendMultiMedia;
import io.objects.tl.api.request.TLRequestMessagesSendScreenshotNotification;
import io.objects.tl.api.request.TLRequestMessagesSetBotCallbackAnswer;
import io.objects.tl.api.request.TLRequestMessagesSetBotPrecheckoutResults;
import io.objects.tl.api.request.TLRequestMessagesSetBotShippingResults;
import io.objects.tl.api.request.TLRequestMessagesSetEncryptedTyping;
import io.objects.tl.api.request.TLRequestMessagesSetGameScore;
import io.objects.tl.api.request.TLRequestMessagesSetInlineBotResults;
import io.objects.tl.api.request.TLRequestMessagesSetInlineGameScore;
import io.objects.tl.api.request.TLRequestMessagesSetTyping;
import io.objects.tl.api.request.TLRequestMessagesStartBot;
import io.objects.tl.api.request.TLRequestMessagesToggleChatAdmins;
import io.objects.tl.api.request.TLRequestMessagesToggleDialogPin;
import io.objects.tl.api.request.TLRequestMessagesUninstallStickerSet;
import io.objects.tl.api.request.TLRequestMessagesUploadEncryptedFile;
import io.objects.tl.api.request.TLRequestMessagesUploadMedia;
import io.objects.tl.api.request.TLRequestMonobotBotUpdateProfilePhoto;
import io.objects.tl.api.request.TLRequestMonobotDeleteAccount;
import io.objects.tl.api.request.TLRequestMonobotEditInlineBotMessage;
import io.objects.tl.api.request.TLRequestMonobotEditMessage;
import io.objects.tl.api.request.TLRequestMonobotForwardMessages;
import io.objects.tl.api.request.TLRequestMonobotMessagesSetTyping;
import io.objects.tl.api.request.TLRequestMonobotSendMedia;
import io.objects.tl.api.request.TLRequestMonobotSendMessage;
import io.objects.tl.api.request.TLRequestMonobotSetBotCallbackAnswer;
import io.objects.tl.api.request.TLRequestMonobotSignUp;
import io.objects.tl.api.request.TLRequestMonobotUploadGetFile;
import io.objects.tl.api.request.TLRequestPaymentsClearSavedInfo;
import io.objects.tl.api.request.TLRequestPaymentsGetPaymentForm;
import io.objects.tl.api.request.TLRequestPaymentsGetPaymentReceipt;
import io.objects.tl.api.request.TLRequestPaymentsGetSavedInfo;
import io.objects.tl.api.request.TLRequestPaymentsSendPaymentForm;
import io.objects.tl.api.request.TLRequestPaymentsValidateRequestedInfo;
import io.objects.tl.api.request.TLRequestPhoneAcceptCall;
import io.objects.tl.api.request.TLRequestPhoneConfirmCall;
import io.objects.tl.api.request.TLRequestPhoneDiscardCall;
import io.objects.tl.api.request.TLRequestPhoneGetCallConfig;
import io.objects.tl.api.request.TLRequestPhoneReceivedCall;
import io.objects.tl.api.request.TLRequestPhoneRequestCall;
import io.objects.tl.api.request.TLRequestPhoneSaveCallDebug;
import io.objects.tl.api.request.TLRequestPhoneSetCallRating;
import io.objects.tl.api.request.TLRequestPhotosDeletePhotos;
import io.objects.tl.api.request.TLRequestPhotosGetUserPhotos;
import io.objects.tl.api.request.TLRequestPhotosUpdateProfilePhoto;
import io.objects.tl.api.request.TLRequestPhotosUploadProfilePhoto;
import io.objects.tl.api.request.TLRequestStickersAddStickerToSet;
import io.objects.tl.api.request.TLRequestStickersChangeStickerPosition;
import io.objects.tl.api.request.TLRequestStickersCreateStickerSet;
import io.objects.tl.api.request.TLRequestStickersRemoveStickerFromSet;
import io.objects.tl.api.request.TLRequestUpdatesGetChannelDifference;
import io.objects.tl.api.request.TLRequestUpdatesGetDifference;
import io.objects.tl.api.request.TLRequestUpdatesGetState;
import io.objects.tl.api.request.TLRequestUploadGetCdnFile;
import io.objects.tl.api.request.TLRequestUploadGetCdnFileHashes;
import io.objects.tl.api.request.TLRequestUploadGetFile;
import io.objects.tl.api.request.TLRequestUploadGetFileHashes;
import io.objects.tl.api.request.TLRequestUploadGetWebFile;
import io.objects.tl.api.request.TLRequestUploadReuploadCdnFile;
import io.objects.tl.api.request.TLRequestUploadSaveBigFilePart;
import io.objects.tl.api.request.TLRequestUploadSaveFilePart;
import io.objects.tl.api.request.TLRequestUsersGetFullUser;
import io.objects.tl.api.request.TLRequestUsersGetUsers;
import io.objects.tl.api.request.TLRequestUsersSetSecureValueErrors;
import io.objects.tl.api.updates.TLAbsChannelDifference;
import io.objects.tl.api.updates.TLAbsDifference;
import io.objects.tl.api.updates.TLState;
import io.objects.tl.api.upload.TLAbsCdnFile;
import io.objects.tl.api.upload.TLAbsFile;
import io.objects.tl.api.upload.TLWebFile;
import io.objects.tl.core.TLBool;
import io.objects.tl.core.TLBytes;
import io.objects.tl.core.TLIntVector;
import io.objects.tl.core.TLLongVector;
import io.objects.tl.core.TLMethod;
import io.objects.tl.core.TLObject;
import io.objects.tl.core.TLStringVector;
import io.objects.tl.core.TLVector;
import io.objects.tl.exception.RpcErrorException;
import java.io.IOException;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * This class is generated by Mono's TL class generator
 */
@SuppressWarnings({"unused", "unchecked", "RedundantCast"})
public abstract class TelegramApiWrapper implements TelegramApi {
    public abstract <T extends TLObject> T executeRpcQuery(TLMethod<T> method) throws
            RpcErrorException, IOException;

    @Override
    public TLBool accountAcceptAuthorization(int botId, String scope, String publicKey,
            TLVector<TLSecureValueHash> valueHashes, TLSecureCredentialsEncrypted credentials)
            throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountAcceptAuthorization(botId, scope, publicKey, valueHashes, credentials));
    }

    @Override
    public TLAbsUser accountChangePhone(String phoneNumber, String phoneCodeHash, String phoneCode)
            throws RpcErrorException, IOException {
        return (TLAbsUser) executeRpcQuery(new TLRequestAccountChangePhone(phoneNumber, phoneCodeHash, phoneCode));
    }

    @Override
    public TLBool accountCheckUsername(String username) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountCheckUsername(username));
    }

    @Override
    public TLBool accountConfirmPhone(String phoneCodeHash, String phoneCode) throws
            RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountConfirmPhone(phoneCodeHash, phoneCode));
    }

    @Override
    public TLBool accountDeleteAccount(String reason) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountDeleteAccount(reason));
    }

    @Override
    public TLBool accountDeleteSecureValue(TLVector<TLAbsSecureValueType> types) throws
            RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountDeleteSecureValue(types));
    }

    @Override
    public TLBool accountFinishTakeoutSession(boolean success) throws RpcErrorException,
            IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountFinishTakeoutSession(success));
    }

    @Override
    public TLAccountDaysTTL accountGetAccountTTL() throws RpcErrorException, IOException {
        return (TLAccountDaysTTL) executeRpcQuery(new TLRequestAccountGetAccountTTL());
    }

    @Override
    public TLVector<TLSecureValue> accountGetAllSecureValues() throws RpcErrorException,
            IOException {
        return (TLVector<TLSecureValue>) executeRpcQuery(new TLRequestAccountGetAllSecureValues());
    }

    @Override
    public TLAuthorizationForm accountGetAuthorizationForm(int botId, String scope,
            String publicKey) throws RpcErrorException, IOException {
        return (TLAuthorizationForm) executeRpcQuery(new TLRequestAccountGetAuthorizationForm(botId, scope, publicKey));
    }

    @Override
    public TLAuthorizations accountGetAuthorizations() throws RpcErrorException, IOException {
        return (TLAuthorizations) executeRpcQuery(new TLRequestAccountGetAuthorizations());
    }

    @Override
    public TLPeerNotifySettings accountGetNotifySettings(TLAbsInputNotifyPeer peer) throws
            RpcErrorException, IOException {
        return (TLPeerNotifySettings) executeRpcQuery(new TLRequestAccountGetNotifySettings(peer));
    }

    @Override
    public TLPassword accountGetPassword() throws RpcErrorException, IOException {
        return (TLPassword) executeRpcQuery(new TLRequestAccountGetPassword());
    }

    @Override
    public TLPasswordSettings accountGetPasswordSettings(TLAbsInputCheckPasswordSRP password) throws
            RpcErrorException, IOException {
        return (TLPasswordSettings) executeRpcQuery(new TLRequestAccountGetPasswordSettings(password));
    }

    @Override
    public TLPrivacyRules accountGetPrivacy(TLAbsInputPrivacyKey key) throws RpcErrorException,
            IOException {
        return (TLPrivacyRules) executeRpcQuery(new TLRequestAccountGetPrivacy(key));
    }

    @Override
    public TLVector<TLSecureValue> accountGetSecureValue(TLVector<TLAbsSecureValueType> types)
            throws RpcErrorException, IOException {
        return (TLVector<TLSecureValue>) executeRpcQuery(new TLRequestAccountGetSecureValue(types));
    }

    @Override
    public TLTmpPassword accountGetTmpPassword(TLAbsInputCheckPasswordSRP password, int period)
            throws RpcErrorException, IOException {
        return (TLTmpPassword) executeRpcQuery(new TLRequestAccountGetTmpPassword(password, period));
    }

    @Override
    public TLVector<TLAbsWallPaper> accountGetWallPapers() throws RpcErrorException, IOException {
        return (TLVector<TLAbsWallPaper>) executeRpcQuery(new TLRequestAccountGetWallPapers());
    }

    @Override
    public TLWebAuthorizations accountGetWebAuthorizations() throws RpcErrorException, IOException {
        return (TLWebAuthorizations) executeRpcQuery(new TLRequestAccountGetWebAuthorizations());
    }

    @Override
    public TLTakeout accountInitTakeoutSession(boolean contacts, boolean messageUsers,
            boolean messageChats, boolean messageMegagroups, boolean messageChannels, boolean files,
            Integer fileMaxSize) throws RpcErrorException, IOException {
        return (TLTakeout) executeRpcQuery(new TLRequestAccountInitTakeoutSession(contacts, messageUsers, messageChats, messageMegagroups, messageChannels, files, fileMaxSize));
    }

    @Override
    public TLBool accountRegisterDevice(int tokenType, String token, boolean appSandbox,
            TLBytes secret, TLIntVector otherUids) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountRegisterDevice(tokenType, token, appSandbox, secret, otherUids));
    }

    @Override
    public TLBool accountRegisterDeviceV71(int tokenType, String token) throws RpcErrorException,
            IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountRegisterDeviceV71(tokenType, token));
    }

    @Override
    public TLBool accountReportPeer(TLAbsInputPeer peer, TLAbsReportReason reason) throws
            RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountReportPeer(peer, reason));
    }

    @Override
    public TLBool accountResetAuthorization(long hash) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountResetAuthorization(hash));
    }

    @Override
    public TLBool accountResetNotifySettings() throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountResetNotifySettings());
    }

    @Override
    public TLBool accountResetWebAuthorization(long hash) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountResetWebAuthorization(hash));
    }

    @Override
    public TLBool accountResetWebAuthorizations() throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountResetWebAuthorizations());
    }

    @Override
    public TLSecureValue accountSaveSecureValue(TLInputSecureValue value, long secureSecretId)
            throws RpcErrorException, IOException {
        return (TLSecureValue) executeRpcQuery(new TLRequestAccountSaveSecureValue(value, secureSecretId));
    }

    @Override
    public TLSentCode accountSendChangePhoneCode(boolean allowFlashcall, String phoneNumber,
            boolean currentNumber) throws RpcErrorException, IOException {
        return (TLSentCode) executeRpcQuery(new TLRequestAccountSendChangePhoneCode(allowFlashcall, phoneNumber, currentNumber));
    }

    @Override
    public TLSentCode accountSendConfirmPhoneCode(boolean allowFlashcall, String hash,
            boolean currentNumber) throws RpcErrorException, IOException {
        return (TLSentCode) executeRpcQuery(new TLRequestAccountSendConfirmPhoneCode(allowFlashcall, hash, currentNumber));
    }

    @Override
    public TLSentEmailCode accountSendVerifyEmailCode(String email) throws RpcErrorException,
            IOException {
        return (TLSentEmailCode) executeRpcQuery(new TLRequestAccountSendVerifyEmailCode(email));
    }

    @Override
    public TLSentCode accountSendVerifyPhoneCode(boolean allowFlashcall, String phoneNumber,
            boolean currentNumber) throws RpcErrorException, IOException {
        return (TLSentCode) executeRpcQuery(new TLRequestAccountSendVerifyPhoneCode(allowFlashcall, phoneNumber, currentNumber));
    }

    @Override
    public TLBool accountSetAccountTTL(TLAccountDaysTTL ttl) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountSetAccountTTL(ttl));
    }

    @Override
    public TLPrivacyRules accountSetPrivacy(TLAbsInputPrivacyKey key,
            TLVector<TLAbsInputPrivacyRule> rules) throws RpcErrorException, IOException {
        return (TLPrivacyRules) executeRpcQuery(new TLRequestAccountSetPrivacy(key, rules));
    }

    @Override
    public TLBool accountUnregisterDevice(int tokenType, String token, TLIntVector otherUids) throws
            RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountUnregisterDevice(tokenType, token, otherUids));
    }

    @Override
    public TLBool accountUpdateDeviceLocked(int period) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountUpdateDeviceLocked(period));
    }

    @Override
    public TLBool accountUpdateNotifySettings(TLAbsInputNotifyPeer peer,
            TLInputPeerNotifySettings settings) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountUpdateNotifySettings(peer, settings));
    }

    @Override
    public TLBool accountUpdatePasswordSettings(TLAbsInputCheckPasswordSRP password,
            TLPasswordInputSettings newSettings) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountUpdatePasswordSettings(password, newSettings));
    }

    @Override
    public TLAbsUser accountUpdateProfile(String firstName, String lastName, String about) throws
            RpcErrorException, IOException {
        return (TLAbsUser) executeRpcQuery(new TLRequestAccountUpdateProfile(firstName, lastName, about));
    }

    @Override
    public TLBool accountUpdateStatus(boolean offline) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountUpdateStatus(offline));
    }

    @Override
    public TLAbsUser accountUpdateUsername(String username) throws RpcErrorException, IOException {
        return (TLAbsUser) executeRpcQuery(new TLRequestAccountUpdateUsername(username));
    }

    @Override
    public TLBool accountVerifyEmail(String email, String code) throws RpcErrorException,
            IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountVerifyEmail(email, code));
    }

    @Override
    public TLBool accountVerifyPhone(String phoneNumber, String phoneCodeHash, String phoneCode)
            throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountVerifyPhone(phoneNumber, phoneCodeHash, phoneCode));
    }

    @Override
    public TLBool authBindTempAuthKey(long permAuthKeyId, long nonce, int expiresAt,
            TLBytes encryptedMessage) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAuthBindTempAuthKey(permAuthKeyId, nonce, expiresAt, encryptedMessage));
    }

    @Override
    public TLBool authCancelCode(String phoneNumber, String phoneCodeHash) throws RpcErrorException,
            IOException {
        return (TLBool) executeRpcQuery(new TLRequestAuthCancelCode(phoneNumber, phoneCodeHash));
    }

    @Override
    public TLAuthorization authCheckPassword(TLAbsInputCheckPasswordSRP password) throws
            RpcErrorException, IOException {
        return (TLAuthorization) executeRpcQuery(new TLRequestAuthCheckPassword(password));
    }

    @Override
    public TLBool authDropTempAuthKeys(TLLongVector exceptAuthKeys) throws RpcErrorException,
            IOException {
        return (TLBool) executeRpcQuery(new TLRequestAuthDropTempAuthKeys(exceptAuthKeys));
    }

    @Override
    public TLExportedAuthorization authExportAuthorization(int dcId) throws RpcErrorException,
            IOException {
        return (TLExportedAuthorization) executeRpcQuery(new TLRequestAuthExportAuthorization(dcId));
    }

    @Override
    public TLAuthorization authImportAuthorization(int id, TLBytes bytes) throws RpcErrorException,
            IOException {
        return (TLAuthorization) executeRpcQuery(new TLRequestAuthImportAuthorization(id, bytes));
    }

    @Override
    public TLAuthorization authImportBotAuthorization(int flags, int apiId, String apiHash,
            String botAuthToken) throws RpcErrorException, IOException {
        return (TLAuthorization) executeRpcQuery(new TLRequestAuthImportBotAuthorization(flags, apiId, apiHash, botAuthToken));
    }

    @Override
    public TLBool authLogOut() throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAuthLogOut());
    }

    @Override
    public TLAuthorization authRecoverPassword(String code) throws RpcErrorException, IOException {
        return (TLAuthorization) executeRpcQuery(new TLRequestAuthRecoverPassword(code));
    }

    @Override
    public TLPasswordRecovery authRequestPasswordRecovery() throws RpcErrorException, IOException {
        return (TLPasswordRecovery) executeRpcQuery(new TLRequestAuthRequestPasswordRecovery());
    }

    @Override
    public TLSentCode authResendCode(String phoneNumber, String phoneCodeHash) throws
            RpcErrorException, IOException {
        return (TLSentCode) executeRpcQuery(new TLRequestAuthResendCode(phoneNumber, phoneCodeHash));
    }

    @Override
    public TLBool authResetAuthorizations() throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAuthResetAuthorizations());
    }

    @Override
    public TLSentCode authSendCode(boolean allowFlashcall, String phoneNumber,
            boolean currentNumber, int apiId, String apiHash) throws RpcErrorException,
            IOException {
        return (TLSentCode) executeRpcQuery(new TLRequestAuthSendCode(allowFlashcall, phoneNumber, currentNumber, apiId, apiHash));
    }

    @Override
    public TLAuthorization authSignIn(String phoneNumber, String phoneCodeHash, String phoneCode)
            throws RpcErrorException, IOException {
        return (TLAuthorization) executeRpcQuery(new TLRequestAuthSignIn(phoneNumber, phoneCodeHash, phoneCode));
    }

    @Override
    public TLAuthorization authSignUp(String phoneNumber, String phoneCodeHash, String phoneCode,
            String firstName, String lastName) throws RpcErrorException, IOException {
        return (TLAuthorization) executeRpcQuery(new TLRequestAuthSignUp(phoneNumber, phoneCodeHash, phoneCode, firstName, lastName));
    }

    @Override
    public TLBool botsAnswerWebhookJSONQuery(long queryId, TLDataJSON data) throws
            RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestBotsAnswerWebhookJSONQuery(queryId, data));
    }

    @Override
    public TLDataJSON botsSendCustomRequest(String customMethod, TLDataJSON params) throws
            RpcErrorException, IOException {
        return (TLDataJSON) executeRpcQuery(new TLRequestBotsSendCustomRequest(customMethod, params));
    }

    @Override
    public TLBool channelsCheckUsername(TLAbsInputChannel channel, String username) throws
            RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestChannelsCheckUsername(channel, username));
    }

    @Override
    public TLAbsUpdates channelsCreateChannel(boolean broadcast, boolean megagroup, String title,
            String about) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsCreateChannel(broadcast, megagroup, title, about));
    }

    @Override
    public TLAbsUpdates channelsDeleteChannel(TLAbsInputChannel channel) throws RpcErrorException,
            IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsDeleteChannel(channel));
    }

    @Override
    public TLBool channelsDeleteHistory(TLAbsInputChannel channel, int maxId) throws
            RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestChannelsDeleteHistory(channel, maxId));
    }

    @Override
    public TLAffectedMessages channelsDeleteMessages(TLAbsInputChannel channel, TLIntVector id)
            throws RpcErrorException, IOException {
        return (TLAffectedMessages) executeRpcQuery(new TLRequestChannelsDeleteMessages(channel, id));
    }

    @Override
    public TLAffectedHistory channelsDeleteUserHistory(TLAbsInputChannel channel,
            TLAbsInputUser userId) throws RpcErrorException, IOException {
        return (TLAffectedHistory) executeRpcQuery(new TLRequestChannelsDeleteUserHistory(channel, userId));
    }

    @Override
    public TLBool channelsEditAbout(TLAbsInputChannel channel, String about) throws
            RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestChannelsEditAbout(channel, about));
    }

    @Override
    public TLAbsUpdates channelsEditAdmin(TLAbsInputChannel channel, TLAbsInputUser userId,
            TLChannelAdminRights adminRights) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsEditAdmin(channel, userId, adminRights));
    }

    @Override
    public TLAbsUpdates channelsEditBanned(TLAbsInputChannel channel, TLAbsInputUser userId,
            TLChannelBannedRights bannedRights) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsEditBanned(channel, userId, bannedRights));
    }

    @Override
    public TLAbsUpdates channelsEditPhoto(TLAbsInputChannel channel, TLAbsInputChatPhoto photo)
            throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsEditPhoto(channel, photo));
    }

    @Override
    public TLAbsUpdates channelsEditTitle(TLAbsInputChannel channel, String title) throws
            RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsEditTitle(channel, title));
    }

    @Override
    public TLAbsExportedChatInvite channelsExportInvite(TLAbsInputChannel channel) throws
            RpcErrorException, IOException {
        return (TLAbsExportedChatInvite) executeRpcQuery(new TLRequestChannelsExportInvite(channel));
    }

    @Override
    public TLExportedMessageLink channelsExportMessageLink(TLAbsInputChannel channel, int id,
            boolean grouped) throws RpcErrorException, IOException {
        return (TLExportedMessageLink) executeRpcQuery(new TLRequestChannelsExportMessageLink(channel, id, grouped));
    }

    @Override
    public TLAdminLogResults channelsGetAdminLog(TLAbsInputChannel channel, String q,
            TLChannelAdminLogEventsFilter eventsFilter, TLVector<TLAbsInputUser> admins, long maxId,
            long minId, int limit) throws RpcErrorException, IOException {
        return (TLAdminLogResults) executeRpcQuery(new TLRequestChannelsGetAdminLog(channel, q, eventsFilter, admins, maxId, minId, limit));
    }

    @Override
    public TLAbsChats channelsGetAdminedPublicChannels() throws RpcErrorException, IOException {
        return (TLAbsChats) executeRpcQuery(new TLRequestChannelsGetAdminedPublicChannels());
    }

    @Override
    public TLAbsChats channelsGetChannels(TLVector<TLAbsInputChannel> id) throws RpcErrorException,
            IOException {
        return (TLAbsChats) executeRpcQuery(new TLRequestChannelsGetChannels(id));
    }

    @Override
    public TLChatFull channelsGetFullChannel(TLAbsInputChannel channel) throws RpcErrorException,
            IOException {
        return (TLChatFull) executeRpcQuery(new TLRequestChannelsGetFullChannel(channel));
    }

    @Override
    public TLAbsChats channelsGetLeftChannels(int offset) throws RpcErrorException, IOException {
        return (TLAbsChats) executeRpcQuery(new TLRequestChannelsGetLeftChannels(offset));
    }

    @Override
    public TLAbsMessages channelsGetMessages(TLAbsInputChannel channel,
            TLVector<TLAbsInputMessage> id) throws RpcErrorException, IOException {
        return (TLAbsMessages) executeRpcQuery(new TLRequestChannelsGetMessages(channel, id));
    }

    @Override
    public TLChannelParticipant channelsGetParticipant(TLAbsInputChannel channel,
            TLAbsInputUser userId) throws RpcErrorException, IOException {
        return (TLChannelParticipant) executeRpcQuery(new TLRequestChannelsGetParticipant(channel, userId));
    }

    @Override
    public TLAbsChannelParticipants channelsGetParticipants(TLAbsInputChannel channel,
            TLAbsChannelParticipantsFilter filter, int offset, int limit, int hash) throws
            RpcErrorException, IOException {
        return (TLAbsChannelParticipants) executeRpcQuery(new TLRequestChannelsGetParticipants(channel, filter, offset, limit, hash));
    }

    @Override
    public TLAbsUpdates channelsInviteToChannel(TLAbsInputChannel channel,
            TLVector<TLAbsInputUser> users) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsInviteToChannel(channel, users));
    }

    @Override
    public TLAbsUpdates channelsJoinChannel(TLAbsInputChannel channel) throws RpcErrorException,
            IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsJoinChannel(channel));
    }

    @Override
    public TLAbsUpdates channelsLeaveChannel(TLAbsInputChannel channel) throws RpcErrorException,
            IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsLeaveChannel(channel));
    }

    @Override
    public TLBool channelsReadHistory(TLAbsInputChannel channel, int maxId) throws
            RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestChannelsReadHistory(channel, maxId));
    }

    @Override
    public TLBool channelsReadMessageContents(TLAbsInputChannel channel, TLIntVector id) throws
            RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestChannelsReadMessageContents(channel, id));
    }

    @Override
    public TLBool channelsReportSpam(TLAbsInputChannel channel, TLAbsInputUser userId,
            TLIntVector id) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestChannelsReportSpam(channel, userId, id));
    }

    @Override
    public TLBool channelsSetStickers(TLAbsInputChannel channel, TLAbsInputStickerSet stickerset)
            throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestChannelsSetStickers(channel, stickerset));
    }

    @Override
    public TLAbsUpdates channelsToggleInvites(TLAbsInputChannel channel, boolean enabled) throws
            RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsToggleInvites(channel, enabled));
    }

    @Override
    public TLAbsUpdates channelsTogglePreHistoryHidden(TLAbsInputChannel channel, boolean enabled)
            throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsTogglePreHistoryHidden(channel, enabled));
    }

    @Override
    public TLAbsUpdates channelsToggleSignatures(TLAbsInputChannel channel, boolean enabled) throws
            RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsToggleSignatures(channel, enabled));
    }

    @Override
    public TLAbsUpdates channelsUpdatePinnedMessage(boolean silent, TLAbsInputChannel channel,
            int id) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsUpdatePinnedMessage(silent, channel, id));
    }

    @Override
    public TLBool channelsUpdateUsername(TLAbsInputChannel channel, String username) throws
            RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestChannelsUpdateUsername(channel, username));
    }

    @Override
    public TLBool contactsBlock(TLAbsInputUser id) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestContactsBlock(id));
    }

    @Override
    public TLLink contactsDeleteContact(TLAbsInputUser id) throws RpcErrorException, IOException {
        return (TLLink) executeRpcQuery(new TLRequestContactsDeleteContact(id));
    }

    @Override
    public TLBool contactsDeleteContacts(TLVector<TLAbsInputUser> id) throws RpcErrorException,
            IOException {
        return (TLBool) executeRpcQuery(new TLRequestContactsDeleteContacts(id));
    }

    @Override
    public TLIntVector contactsExportCard() throws RpcErrorException, IOException {
        return (TLIntVector) executeRpcQuery(new TLRequestContactsExportCard());
    }

    @Override
    public TLAbsBlocked contactsGetBlocked(int offset, int limit) throws RpcErrorException,
            IOException {
        return (TLAbsBlocked) executeRpcQuery(new TLRequestContactsGetBlocked(offset, limit));
    }

    @Override
    public TLAbsContacts contactsGetContacts(int hash) throws RpcErrorException, IOException {
        return (TLAbsContacts) executeRpcQuery(new TLRequestContactsGetContacts(hash));
    }

    @Override
    public TLVector<TLSavedPhoneContact> contactsGetSaved() throws RpcErrorException, IOException {
        return (TLVector<TLSavedPhoneContact>) executeRpcQuery(new TLRequestContactsGetSaved());
    }

    @Override
    public TLVector<TLContactStatus> contactsGetStatuses() throws RpcErrorException, IOException {
        return (TLVector<TLContactStatus>) executeRpcQuery(new TLRequestContactsGetStatuses());
    }

    @Override
    public TLAbsTopPeers contactsGetTopPeers(boolean correspondents, boolean botsPm,
            boolean botsInline, boolean phoneCalls, boolean groups, boolean channels, int offset,
            int limit, int hash) throws RpcErrorException, IOException {
        return (TLAbsTopPeers) executeRpcQuery(new TLRequestContactsGetTopPeers(correspondents, botsPm, botsInline, phoneCalls, groups, channels, offset, limit, hash));
    }

    @Override
    public TLAbsUser contactsImportCard(TLIntVector exportCard) throws RpcErrorException,
            IOException {
        return (TLAbsUser) executeRpcQuery(new TLRequestContactsImportCard(exportCard));
    }

    @Override
    public TLImportedContacts contactsImportContacts(TLVector<TLInputPhoneContact> contacts) throws
            RpcErrorException, IOException {
        return (TLImportedContacts) executeRpcQuery(new TLRequestContactsImportContacts(contacts));
    }

    @Override
    public TLBool contactsResetSaved() throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestContactsResetSaved());
    }

    @Override
    public TLBool contactsResetTopPeerRating(TLAbsTopPeerCategory category, TLAbsInputPeer peer)
            throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestContactsResetTopPeerRating(category, peer));
    }

    @Override
    public TLResolvedPeer contactsResolveUsername(String username) throws RpcErrorException,
            IOException {
        return (TLResolvedPeer) executeRpcQuery(new TLRequestContactsResolveUsername(username));
    }

    @Override
    public TLFound contactsSearch(String q, int limit) throws RpcErrorException, IOException {
        return (TLFound) executeRpcQuery(new TLRequestContactsSearch(q, limit));
    }

    @Override
    public TLBool contactsToggleTopPeers(boolean enabled) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestContactsToggleTopPeers(enabled));
    }

    @Override
    public TLBool contactsUnblock(TLAbsInputUser id) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestContactsUnblock(id));
    }

    @Override
    public TLBool helpAcceptTermsOfService(TLDataJSON id) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestHelpAcceptTermsOfService(id));
    }

    @Override
    public TLAbsUpdates helpGetAppChangelog(String prevAppVersion) throws RpcErrorException,
            IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestHelpGetAppChangelog(prevAppVersion));
    }

    @Override
    public TLAbsAppUpdate helpGetAppUpdate(String source) throws RpcErrorException, IOException {
        return (TLAbsAppUpdate) executeRpcQuery(new TLRequestHelpGetAppUpdate(source));
    }

    @Override
    public TLCdnConfig helpGetCdnConfig() throws RpcErrorException, IOException {
        return (TLCdnConfig) executeRpcQuery(new TLRequestHelpGetCdnConfig());
    }

    @Override
    public TLConfig helpGetConfig() throws RpcErrorException, IOException {
        return (TLConfig) executeRpcQuery(new TLRequestHelpGetConfig());
    }

    @Override
    public TLAbsDeepLinkInfo helpGetDeepLinkInfo(String path) throws RpcErrorException,
            IOException {
        return (TLAbsDeepLinkInfo) executeRpcQuery(new TLRequestHelpGetDeepLinkInfo(path));
    }

    @Override
    public TLInviteText helpGetInviteText() throws RpcErrorException, IOException {
        return (TLInviteText) executeRpcQuery(new TLRequestHelpGetInviteText());
    }

    @Override
    public TLNearestDc helpGetNearestDc() throws RpcErrorException, IOException {
        return (TLNearestDc) executeRpcQuery(new TLRequestHelpGetNearestDc());
    }

    @Override
    public TLAbsPassportConfig helpGetPassportConfig(int hash) throws RpcErrorException,
            IOException {
        return (TLAbsPassportConfig) executeRpcQuery(new TLRequestHelpGetPassportConfig(hash));
    }

    @Override
    public TLAbsProxyData helpGetProxyData() throws RpcErrorException, IOException {
        return (TLAbsProxyData) executeRpcQuery(new TLRequestHelpGetProxyData());
    }

    @Override
    public TLRecentMeUrls helpGetRecentMeUrls(String referer) throws RpcErrorException,
            IOException {
        return (TLRecentMeUrls) executeRpcQuery(new TLRequestHelpGetRecentMeUrls(referer));
    }

    @Override
    public TLSupport helpGetSupport() throws RpcErrorException, IOException {
        return (TLSupport) executeRpcQuery(new TLRequestHelpGetSupport());
    }

    @Override
    public TLBool helpSaveAppLog(TLVector<TLInputAppEvent> events) throws RpcErrorException,
            IOException {
        return (TLBool) executeRpcQuery(new TLRequestHelpSaveAppLog(events));
    }

    @Override
    public TLBool helpSetBotUpdatesStatus(int pendingUpdatesCount, String message) throws
            RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestHelpSetBotUpdatesStatus(pendingUpdatesCount, message));
    }

    @Override
    public <T extends TLObject> T initConnection(int apiId, String deviceModel,
            String systemVersion, String appVersion, String systemLangCode, String langPack,
            String langCode, TLInputClientProxy proxy, TLMethod<T> query) throws RpcErrorException,
            IOException {
        return (T) executeRpcQuery(new TLRequestInitConnection(apiId, deviceModel, systemVersion, appVersion, systemLangCode, langPack, langCode, proxy, query));
    }

    @Override
    public <T extends TLObject> T invokeAfterMsg(long msgId, TLMethod<T> query) throws
            RpcErrorException, IOException {
        return (T) executeRpcQuery(new TLRequestInvokeAfterMsg(msgId, query));
    }

    @Override
    public <T extends TLObject> T invokeAfterMsgs(TLLongVector msgIds, TLMethod<T> query) throws
            RpcErrorException, IOException {
        return (T) executeRpcQuery(new TLRequestInvokeAfterMsgs(msgIds, query));
    }

    @Override
    public <T extends TLObject> T invokeWithLayer(int layer, TLMethod<T> query) throws
            RpcErrorException, IOException {
        return (T) executeRpcQuery(new TLRequestInvokeWithLayer(layer, query));
    }

    @Override
    public <T extends TLObject> T invokeWithMessagesRange(TLMessageRange range, TLMethod<T> query)
            throws RpcErrorException, IOException {
        return (T) executeRpcQuery(new TLRequestInvokeWithMessagesRange(range, query));
    }

    @Override
    public <T extends TLObject> T invokeWithTakeout(long takeoutId, TLMethod<T> query) throws
            RpcErrorException, IOException {
        return (T) executeRpcQuery(new TLRequestInvokeWithTakeout(takeoutId, query));
    }

    @Override
    public <T extends TLObject> T invokeWithoutUpdates(TLMethod<T> query) throws RpcErrorException,
            IOException {
        return (T) executeRpcQuery(new TLRequestInvokeWithoutUpdates(query));
    }

    @Override
    public TLLangPackDifference langpackGetDifference(int fromVersion) throws RpcErrorException,
            IOException {
        return (TLLangPackDifference) executeRpcQuery(new TLRequestLangpackGetDifference(fromVersion));
    }

    @Override
    public TLLangPackDifference langpackGetLangPack(String langPack, String langCode) throws
            RpcErrorException, IOException {
        return (TLLangPackDifference) executeRpcQuery(new TLRequestLangpackGetLangPack(langPack, langCode));
    }

    @Override
    public TLVector<TLLangPackLanguage> langpackGetLanguages(String langPack) throws
            RpcErrorException, IOException {
        return (TLVector<TLLangPackLanguage>) executeRpcQuery(new TLRequestLangpackGetLanguages(langPack));
    }

    @Override
    public TLVector<TLAbsLangPackString> langpackGetStrings(String langPack, String langCode,
            TLStringVector keys) throws RpcErrorException, IOException {
        return (TLVector<TLAbsLangPackString>) executeRpcQuery(new TLRequestLangpackGetStrings(langPack, langCode, keys));
    }

    @Override
    public TLAbsEncryptedChat messagesAcceptEncryption(TLInputEncryptedChat peer, TLBytes gB,
            long keyFingerprint) throws RpcErrorException, IOException {
        return (TLAbsEncryptedChat) executeRpcQuery(new TLRequestMessagesAcceptEncryption(peer, gB, keyFingerprint));
    }

    @Override
    public TLAbsUpdates messagesAddChatUser(int chatId, TLAbsInputUser userId, int fwdLimit) throws
            RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesAddChatUser(chatId, userId, fwdLimit));
    }

    @Override
    public TLAbsChatInvite messagesCheckChatInvite(String hash) throws RpcErrorException,
            IOException {
        return (TLAbsChatInvite) executeRpcQuery(new TLRequestMessagesCheckChatInvite(hash));
    }

    @Override
    public TLBool messagesClearAllDrafts() throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesClearAllDrafts());
    }

    @Override
    public TLBool messagesClearRecentStickers(boolean attached) throws RpcErrorException,
            IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesClearRecentStickers(attached));
    }

    @Override
    public TLAbsUpdates messagesCreateChat(TLVector<TLAbsInputUser> users, String title) throws
            RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesCreateChat(users, title));
    }

    @Override
    public TLAbsUpdates messagesDeleteChatUser(int chatId, TLAbsInputUser userId) throws
            RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesDeleteChatUser(chatId, userId));
    }

    @Override
    public TLAffectedHistory messagesDeleteHistory(boolean justClear, TLAbsInputPeer peer,
            int maxId) throws RpcErrorException, IOException {
        return (TLAffectedHistory) executeRpcQuery(new TLRequestMessagesDeleteHistory(justClear, peer, maxId));
    }

    @Override
    public TLAffectedMessages messagesDeleteMessages(boolean revoke, TLIntVector id) throws
            RpcErrorException, IOException {
        return (TLAffectedMessages) executeRpcQuery(new TLRequestMessagesDeleteMessages(revoke, id));
    }

    @Override
    public TLBool messagesDiscardEncryption(int chatId) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesDiscardEncryption(chatId));
    }

    @Override
    public TLBool messagesEditChatAdmin(int chatId, TLAbsInputUser userId, boolean isAdmin) throws
            RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesEditChatAdmin(chatId, userId, isAdmin));
    }

    @Override
    public TLAbsUpdates messagesEditChatPhoto(int chatId, TLAbsInputChatPhoto photo) throws
            RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesEditChatPhoto(chatId, photo));
    }

    @Override
    public TLAbsUpdates messagesEditChatTitle(int chatId, String title) throws RpcErrorException,
            IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesEditChatTitle(chatId, title));
    }

    @Override
    public TLBool messagesEditInlineBotMessage(boolean noWebpage, boolean stopGeoLive,
            TLInputBotInlineMessageID id, String message, TLAbsInputMedia media,
            TLAbsReplyMarkup replyMarkup, TLVector<TLAbsMessageEntity> entities,
            TLAbsInputGeoPoint geoPoint) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesEditInlineBotMessage(noWebpage, stopGeoLive, id, message, media, replyMarkup, entities, geoPoint));
    }

    @Override
    public TLAbsUpdates messagesEditMessage(boolean noWebpage, boolean stopGeoLive,
            TLAbsInputPeer peer, int id, String message, TLAbsInputMedia media,
            TLAbsReplyMarkup replyMarkup, TLVector<TLAbsMessageEntity> entities,
            TLAbsInputGeoPoint geoPoint) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesEditMessage(noWebpage, stopGeoLive, peer, id, message, media, replyMarkup, entities, geoPoint));
    }

    @Override
    public TLAbsExportedChatInvite messagesExportChatInvite(int chatId) throws RpcErrorException,
            IOException {
        return (TLAbsExportedChatInvite) executeRpcQuery(new TLRequestMessagesExportChatInvite(chatId));
    }

    @Override
    public TLBool messagesFaveSticker(TLAbsInputDocument id, boolean unfave) throws
            RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesFaveSticker(id, unfave));
    }

    @Override
    public TLAbsUpdates messagesForwardMessages(boolean silent, boolean background,
            boolean withMyScore, boolean grouped, TLAbsInputPeer fromPeer, TLIntVector id,
            TLLongVector randomId, TLAbsInputPeer toPeer) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesForwardMessages(silent, background, withMyScore, grouped, fromPeer, id, randomId, toPeer));
    }

    @Override
    public TLAbsChats messagesGetAllChats(TLIntVector exceptIds) throws RpcErrorException,
            IOException {
        return (TLAbsChats) executeRpcQuery(new TLRequestMessagesGetAllChats(exceptIds));
    }

    @Override
    public TLAbsUpdates messagesGetAllDrafts() throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesGetAllDrafts());
    }

    @Override
    public TLAbsAllStickers messagesGetAllStickers(int hash) throws RpcErrorException, IOException {
        return (TLAbsAllStickers) executeRpcQuery(new TLRequestMessagesGetAllStickers(hash));
    }

    @Override
    public TLArchivedStickers messagesGetArchivedStickers(boolean masks, long offsetId, int limit)
            throws RpcErrorException, IOException {
        return (TLArchivedStickers) executeRpcQuery(new TLRequestMessagesGetArchivedStickers(masks, offsetId, limit));
    }

    @Override
    public TLVector<TLAbsStickerSetCovered> messagesGetAttachedStickers(
            TLAbsInputStickeredMedia media) throws RpcErrorException, IOException {
        return (TLVector<TLAbsStickerSetCovered>) executeRpcQuery(new TLRequestMessagesGetAttachedStickers(media));
    }

    @Override
    public TLBotCallbackAnswer messagesGetBotCallbackAnswer(boolean game, TLAbsInputPeer peer,
            int msgId, TLBytes data) throws RpcErrorException, IOException {
        return (TLBotCallbackAnswer) executeRpcQuery(new TLRequestMessagesGetBotCallbackAnswer(game, peer, msgId, data));
    }

    @Override
    public TLAbsChats messagesGetChats(TLIntVector id) throws RpcErrorException, IOException {
        return (TLAbsChats) executeRpcQuery(new TLRequestMessagesGetChats(id));
    }

    @Override
    public TLAbsChats messagesGetCommonChats(TLAbsInputUser userId, int maxId, int limit) throws
            RpcErrorException, IOException {
        return (TLAbsChats) executeRpcQuery(new TLRequestMessagesGetCommonChats(userId, maxId, limit));
    }

    @Override
    public TLAbsDhConfig messagesGetDhConfig(int version, int randomLength) throws
            RpcErrorException, IOException {
        return (TLAbsDhConfig) executeRpcQuery(new TLRequestMessagesGetDhConfig(version, randomLength));
    }

    @Override
    public TLVector<TLDialogPeer> messagesGetDialogUnreadMarks() throws RpcErrorException,
            IOException {
        return (TLVector<TLDialogPeer>) executeRpcQuery(new TLRequestMessagesGetDialogUnreadMarks());
    }

    @Override
    public TLAbsDialogs messagesGetDialogs(boolean excludePinned, int offsetDate, int offsetId,
            TLAbsInputPeer offsetPeer, int limit, int hash) throws RpcErrorException, IOException {
        return (TLAbsDialogs) executeRpcQuery(new TLRequestMessagesGetDialogs(excludePinned, offsetDate, offsetId, offsetPeer, limit, hash));
    }

    @Override
    public TLAbsDocument messagesGetDocumentByHash(TLBytes sha256, int size, String mimeType) throws
            RpcErrorException, IOException {
        return (TLAbsDocument) executeRpcQuery(new TLRequestMessagesGetDocumentByHash(sha256, size, mimeType));
    }

    @Override
    public TLAbsFavedStickers messagesGetFavedStickers(int hash) throws RpcErrorException,
            IOException {
        return (TLAbsFavedStickers) executeRpcQuery(new TLRequestMessagesGetFavedStickers(hash));
    }

    @Override
    public TLAbsFeaturedStickers messagesGetFeaturedStickers(int hash) throws RpcErrorException,
            IOException {
        return (TLAbsFeaturedStickers) executeRpcQuery(new TLRequestMessagesGetFeaturedStickers(hash));
    }

    @Override
    public TLChatFull messagesGetFullChat(int chatId) throws RpcErrorException, IOException {
        return (TLChatFull) executeRpcQuery(new TLRequestMessagesGetFullChat(chatId));
    }

    @Override
    public TLHighScores messagesGetGameHighScores(TLAbsInputPeer peer, int id,
            TLAbsInputUser userId) throws RpcErrorException, IOException {
        return (TLHighScores) executeRpcQuery(new TLRequestMessagesGetGameHighScores(peer, id, userId));
    }

    @Override
    public TLAbsMessages messagesGetHistory(TLAbsInputPeer peer, int offsetId, int offsetDate,
            int addOffset, int limit, int maxId, int minId, int hash) throws RpcErrorException,
            IOException {
        return (TLAbsMessages) executeRpcQuery(new TLRequestMessagesGetHistory(peer, offsetId, offsetDate, addOffset, limit, maxId, minId, hash));
    }

    @Override
    public TLBotResults messagesGetInlineBotResults(TLAbsInputUser bot, TLAbsInputPeer peer,
            TLAbsInputGeoPoint geoPoint, String query, String offset) throws RpcErrorException,
            IOException {
        return (TLBotResults) executeRpcQuery(new TLRequestMessagesGetInlineBotResults(bot, peer, geoPoint, query, offset));
    }

    @Override
    public TLHighScores messagesGetInlineGameHighScores(TLInputBotInlineMessageID id,
            TLAbsInputUser userId) throws RpcErrorException, IOException {
        return (TLHighScores) executeRpcQuery(new TLRequestMessagesGetInlineGameHighScores(id, userId));
    }

    @Override
    public TLAbsAllStickers messagesGetMaskStickers(int hash) throws RpcErrorException,
            IOException {
        return (TLAbsAllStickers) executeRpcQuery(new TLRequestMessagesGetMaskStickers(hash));
    }

    @Override
    public TLMessageEditData messagesGetMessageEditData(TLAbsInputPeer peer, int id) throws
            RpcErrorException, IOException {
        return (TLMessageEditData) executeRpcQuery(new TLRequestMessagesGetMessageEditData(peer, id));
    }

    @Override
    public TLAbsMessages messagesGetMessages(TLVector<TLAbsInputMessage> id) throws
            RpcErrorException, IOException {
        return (TLAbsMessages) executeRpcQuery(new TLRequestMessagesGetMessages(id));
    }

    @Override
    public TLAbsMessages messagesGetMessagesV71(TLIntVector id) throws RpcErrorException,
            IOException {
        return (TLAbsMessages) executeRpcQuery(new TLRequestMessagesGetMessagesV71(id));
    }

    @Override
    public TLIntVector messagesGetMessagesViews(TLAbsInputPeer peer, TLIntVector id,
            boolean increment) throws RpcErrorException, IOException {
        return (TLIntVector) executeRpcQuery(new TLRequestMessagesGetMessagesViews(peer, id, increment));
    }

    @Override
    public TLPeerDialogs messagesGetPeerDialogs(TLVector<TLInputDialogPeer> peers) throws
            RpcErrorException, IOException {
        return (TLPeerDialogs) executeRpcQuery(new TLRequestMessagesGetPeerDialogs(peers));
    }

    @Override
    public TLPeerSettings messagesGetPeerSettings(TLAbsInputPeer peer) throws RpcErrorException,
            IOException {
        return (TLPeerSettings) executeRpcQuery(new TLRequestMessagesGetPeerSettings(peer));
    }

    @Override
    public TLPeerDialogs messagesGetPinnedDialogs() throws RpcErrorException, IOException {
        return (TLPeerDialogs) executeRpcQuery(new TLRequestMessagesGetPinnedDialogs());
    }

    @Override
    public TLAbsMessages messagesGetRecentLocations(TLAbsInputPeer peer, int limit, int hash) throws
            RpcErrorException, IOException {
        return (TLAbsMessages) executeRpcQuery(new TLRequestMessagesGetRecentLocations(peer, limit, hash));
    }

    @Override
    public TLAbsRecentStickers messagesGetRecentStickers(boolean attached, int hash) throws
            RpcErrorException, IOException {
        return (TLAbsRecentStickers) executeRpcQuery(new TLRequestMessagesGetRecentStickers(attached, hash));
    }

    @Override
    public TLAbsSavedGifs messagesGetSavedGifs(int hash) throws RpcErrorException, IOException {
        return (TLAbsSavedGifs) executeRpcQuery(new TLRequestMessagesGetSavedGifs(hash));
    }

    @Override
    public TLVector<TLMessageRange> messagesGetSplitRanges() throws RpcErrorException, IOException {
        return (TLVector<TLMessageRange>) executeRpcQuery(new TLRequestMessagesGetSplitRanges());
    }

    @Override
    public TLStickerSet messagesGetStickerSet(TLAbsInputStickerSet stickerset) throws
            RpcErrorException, IOException {
        return (TLStickerSet) executeRpcQuery(new TLRequestMessagesGetStickerSet(stickerset));
    }

    @Override
    public TLAbsStickers messagesGetStickers(String emoticon, int hash) throws RpcErrorException,
            IOException {
        return (TLAbsStickers) executeRpcQuery(new TLRequestMessagesGetStickers(emoticon, hash));
    }

    @Override
    public TLAbsMessages messagesGetUnreadMentions(TLAbsInputPeer peer, int offsetId, int addOffset,
            int limit, int maxId, int minId) throws RpcErrorException, IOException {
        return (TLAbsMessages) executeRpcQuery(new TLRequestMessagesGetUnreadMentions(peer, offsetId, addOffset, limit, maxId, minId));
    }

    @Override
    public TLAbsWebPage messagesGetWebPage(String url, int hash) throws RpcErrorException,
            IOException {
        return (TLAbsWebPage) executeRpcQuery(new TLRequestMessagesGetWebPage(url, hash));
    }

    @Override
    public TLAbsMessageMedia messagesGetWebPagePreview(String message,
            TLVector<TLAbsMessageEntity> entities) throws RpcErrorException, IOException {
        return (TLAbsMessageMedia) executeRpcQuery(new TLRequestMessagesGetWebPagePreview(message, entities));
    }

    @Override
    public TLBool messagesHideReportSpam(TLAbsInputPeer peer) throws RpcErrorException,
            IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesHideReportSpam(peer));
    }

    @Override
    public TLAbsUpdates messagesImportChatInvite(String hash) throws RpcErrorException,
            IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesImportChatInvite(hash));
    }

    @Override
    public TLAbsStickerSetInstallResult messagesInstallStickerSet(TLAbsInputStickerSet stickerset,
            boolean archived) throws RpcErrorException, IOException {
        return (TLAbsStickerSetInstallResult) executeRpcQuery(new TLRequestMessagesInstallStickerSet(stickerset, archived));
    }

    @Override
    public TLBool messagesMarkDialogUnread(boolean unread, TLInputDialogPeer peer) throws
            RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesMarkDialogUnread(unread, peer));
    }

    @Override
    public TLAbsUpdates messagesMigrateChat(int chatId) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesMigrateChat(chatId));
    }

    @Override
    public TLBool messagesReadEncryptedHistory(TLInputEncryptedChat peer, int maxDate) throws
            RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesReadEncryptedHistory(peer, maxDate));
    }

    @Override
    public TLBool messagesReadFeaturedStickers(TLLongVector id) throws RpcErrorException,
            IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesReadFeaturedStickers(id));
    }

    @Override
    public TLAffectedMessages messagesReadHistory(TLAbsInputPeer peer, int maxId) throws
            RpcErrorException, IOException {
        return (TLAffectedMessages) executeRpcQuery(new TLRequestMessagesReadHistory(peer, maxId));
    }

    @Override
    public TLAffectedHistory messagesReadMentions(TLAbsInputPeer peer) throws RpcErrorException,
            IOException {
        return (TLAffectedHistory) executeRpcQuery(new TLRequestMessagesReadMentions(peer));
    }

    @Override
    public TLAffectedMessages messagesReadMessageContents(TLIntVector id) throws RpcErrorException,
            IOException {
        return (TLAffectedMessages) executeRpcQuery(new TLRequestMessagesReadMessageContents(id));
    }

    @Override
    public TLVector<TLReceivedNotifyMessage> messagesReceivedMessages(int maxId) throws
            RpcErrorException, IOException {
        return (TLVector<TLReceivedNotifyMessage>) executeRpcQuery(new TLRequestMessagesReceivedMessages(maxId));
    }

    @Override
    public TLLongVector messagesReceivedQueue(int maxQts) throws RpcErrorException, IOException {
        return (TLLongVector) executeRpcQuery(new TLRequestMessagesReceivedQueue(maxQts));
    }

    @Override
    public TLBool messagesReorderPinnedDialogs(boolean force, TLVector<TLInputDialogPeer> order)
            throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesReorderPinnedDialogs(force, order));
    }

    @Override
    public TLBool messagesReorderStickerSets(boolean masks, TLLongVector order) throws
            RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesReorderStickerSets(masks, order));
    }

    @Override
    public TLBool messagesReport(TLAbsInputPeer peer, TLIntVector id, TLAbsReportReason reason)
            throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesReport(peer, id, reason));
    }

    @Override
    public TLBool messagesReportEncryptedSpam(TLInputEncryptedChat peer) throws RpcErrorException,
            IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesReportEncryptedSpam(peer));
    }

    @Override
    public TLBool messagesReportSpam(TLAbsInputPeer peer) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesReportSpam(peer));
    }

    @Override
    public TLAbsEncryptedChat messagesRequestEncryption(TLAbsInputUser userId, int randomId,
            TLBytes gA) throws RpcErrorException, IOException {
        return (TLAbsEncryptedChat) executeRpcQuery(new TLRequestMessagesRequestEncryption(userId, randomId, gA));
    }

    @Override
    public TLBool messagesSaveDraft(boolean noWebpage, Integer replyToMsgId, TLAbsInputPeer peer,
            String message, TLVector<TLAbsMessageEntity> entities) throws RpcErrorException,
            IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesSaveDraft(noWebpage, replyToMsgId, peer, message, entities));
    }

    @Override
    public TLBool messagesSaveGif(TLAbsInputDocument id, boolean unsave) throws RpcErrorException,
            IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesSaveGif(id, unsave));
    }

    @Override
    public TLBool messagesSaveRecentSticker(boolean attached, TLAbsInputDocument id, boolean unsave)
            throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesSaveRecentSticker(attached, id, unsave));
    }

    @Override
    public TLAbsMessages messagesSearch(TLAbsInputPeer peer, String q, TLAbsInputUser fromId,
            TLAbsMessagesFilter filter, int minDate, int maxDate, int offsetId, int addOffset,
            int limit, int maxId, int minId, int hash) throws RpcErrorException, IOException {
        return (TLAbsMessages) executeRpcQuery(new TLRequestMessagesSearch(peer, q, fromId, filter, minDate, maxDate, offsetId, addOffset, limit, maxId, minId, hash));
    }

    @Override
    public TLFoundGifs messagesSearchGifs(String q, int offset) throws RpcErrorException,
            IOException {
        return (TLFoundGifs) executeRpcQuery(new TLRequestMessagesSearchGifs(q, offset));
    }

    @Override
    public TLAbsMessages messagesSearchGlobal(String q, int offsetDate, TLAbsInputPeer offsetPeer,
            int offsetId, int limit) throws RpcErrorException, IOException {
        return (TLAbsMessages) executeRpcQuery(new TLRequestMessagesSearchGlobal(q, offsetDate, offsetPeer, offsetId, limit));
    }

    @Override
    public TLAbsFoundStickerSets messagesSearchStickerSets(boolean excludeFeatured, String q,
            int hash) throws RpcErrorException, IOException {
        return (TLAbsFoundStickerSets) executeRpcQuery(new TLRequestMessagesSearchStickerSets(excludeFeatured, q, hash));
    }

    @Override
    public TLAbsSentEncryptedMessage messagesSendEncrypted(TLInputEncryptedChat peer, long randomId,
            TLBytes data) throws RpcErrorException, IOException {
        return (TLAbsSentEncryptedMessage) executeRpcQuery(new TLRequestMessagesSendEncrypted(peer, randomId, data));
    }

    @Override
    public TLAbsSentEncryptedMessage messagesSendEncryptedFile(TLInputEncryptedChat peer,
            long randomId, TLBytes data, TLAbsInputEncryptedFile file) throws RpcErrorException,
            IOException {
        return (TLAbsSentEncryptedMessage) executeRpcQuery(new TLRequestMessagesSendEncryptedFile(peer, randomId, data, file));
    }

    @Override
    public TLAbsSentEncryptedMessage messagesSendEncryptedService(TLInputEncryptedChat peer,
            long randomId, TLBytes data) throws RpcErrorException, IOException {
        return (TLAbsSentEncryptedMessage) executeRpcQuery(new TLRequestMessagesSendEncryptedService(peer, randomId, data));
    }

    @Override
    public TLAbsUpdates messagesSendInlineBotResult(boolean silent, boolean background,
            boolean clearDraft, TLAbsInputPeer peer, Integer replyToMsgId, long randomId,
            long queryId, String id) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesSendInlineBotResult(silent, background, clearDraft, peer, replyToMsgId, randomId, queryId, id));
    }

    @Override
    public TLAbsUpdates messagesSendMedia(boolean silent, boolean background, boolean clearDraft,
            TLAbsInputPeer peer, Integer replyToMsgId, TLAbsInputMedia media, String message,
            long randomId, TLAbsReplyMarkup replyMarkup, TLVector<TLAbsMessageEntity> entities)
            throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesSendMedia(silent, background, clearDraft, peer, replyToMsgId, media, message, randomId, replyMarkup, entities));
    }

    @Override
    public TLAbsUpdates messagesSendMessage(boolean noWebpage, boolean silent, boolean background,
            boolean clearDraft, TLAbsInputPeer peer, Integer replyToMsgId, String message,
            long randomId, TLAbsReplyMarkup replyMarkup, TLVector<TLAbsMessageEntity> entities)
            throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesSendMessage(noWebpage, silent, background, clearDraft, peer, replyToMsgId, message, randomId, replyMarkup, entities));
    }

    @Override
    public TLAbsUpdates messagesSendMultiMedia(boolean silent, boolean background,
            boolean clearDraft, TLAbsInputPeer peer, Integer replyToMsgId,
            TLVector<TLInputSingleMedia> multiMedia) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesSendMultiMedia(silent, background, clearDraft, peer, replyToMsgId, multiMedia));
    }

    @Override
    public TLAbsUpdates messagesSendScreenshotNotification(TLAbsInputPeer peer, int replyToMsgId,
            long randomId) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesSendScreenshotNotification(peer, replyToMsgId, randomId));
    }

    @Override
    public TLBool messagesSetBotCallbackAnswer(boolean alert, long queryId, String message,
            String url, int cacheTime) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesSetBotCallbackAnswer(alert, queryId, message, url, cacheTime));
    }

    @Override
    public TLBool messagesSetBotPrecheckoutResults(boolean success, long queryId, String error)
            throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesSetBotPrecheckoutResults(success, queryId, error));
    }

    @Override
    public TLBool messagesSetBotShippingResults(long queryId, String error,
            TLVector<TLShippingOption> shippingOptions) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesSetBotShippingResults(queryId, error, shippingOptions));
    }

    @Override
    public TLBool messagesSetEncryptedTyping(TLInputEncryptedChat peer, boolean typing) throws
            RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesSetEncryptedTyping(peer, typing));
    }

    @Override
    public TLAbsUpdates messagesSetGameScore(boolean editMessage, boolean force,
            TLAbsInputPeer peer, int id, TLAbsInputUser userId, int score) throws RpcErrorException,
            IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesSetGameScore(editMessage, force, peer, id, userId, score));
    }

    @Override
    public TLBool messagesSetInlineBotResults(boolean gallery, boolean _private, long queryId,
            TLVector<TLAbsInputBotInlineResult> results, int cacheTime, String nextOffset,
            TLInlineBotSwitchPM switchPm) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesSetInlineBotResults(gallery, _private, queryId, results, cacheTime, nextOffset, switchPm));
    }

    @Override
    public TLBool messagesSetInlineGameScore(boolean editMessage, boolean force,
            TLInputBotInlineMessageID id, TLAbsInputUser userId, int score) throws
            RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesSetInlineGameScore(editMessage, force, id, userId, score));
    }

    @Override
    public TLBool messagesSetTyping(TLAbsInputPeer peer, TLAbsSendMessageAction action) throws
            RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesSetTyping(peer, action));
    }

    @Override
    public TLAbsUpdates messagesStartBot(TLAbsInputUser bot, TLAbsInputPeer peer, long randomId,
            String startParam) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesStartBot(bot, peer, randomId, startParam));
    }

    @Override
    public TLAbsUpdates messagesToggleChatAdmins(int chatId, boolean enabled) throws
            RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesToggleChatAdmins(chatId, enabled));
    }

    @Override
    public TLBool messagesToggleDialogPin(boolean pinned, TLInputDialogPeer peer) throws
            RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesToggleDialogPin(pinned, peer));
    }

    @Override
    public TLBool messagesUninstallStickerSet(TLAbsInputStickerSet stickerset) throws
            RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesUninstallStickerSet(stickerset));
    }

    @Override
    public TLAbsEncryptedFile messagesUploadEncryptedFile(TLInputEncryptedChat peer,
            TLAbsInputEncryptedFile file) throws RpcErrorException, IOException {
        return (TLAbsEncryptedFile) executeRpcQuery(new TLRequestMessagesUploadEncryptedFile(peer, file));
    }

    @Override
    public TLAbsMessageMedia messagesUploadMedia(TLAbsInputPeer peer, TLAbsInputMedia media) throws
            RpcErrorException, IOException {
        return (TLAbsMessageMedia) executeRpcQuery(new TLRequestMessagesUploadMedia(peer, media));
    }

    @Override
    public TLAbsBotUserProfilePhoto monobotBotUpdateProfilePhoto(TLAbsInputPhoto id, long requestId,
            int botId) throws RpcErrorException, IOException {
        return (TLAbsBotUserProfilePhoto) executeRpcQuery(new TLRequestMonobotBotUpdateProfilePhoto(id, requestId, botId));
    }

    @Override
    public TLBotUpdates monobotDeleteAccount(String reason, long requestId, int botId) throws
            RpcErrorException, IOException {
        return (TLBotUpdates) executeRpcQuery(new TLRequestMonobotDeleteAccount(reason, requestId, botId));
    }

    @Override
    public TLBotUpdates monobotEditInlineBotMessage(boolean noWebpage, boolean stopGeoLive,
            TLInputBotInlineMessageID id, String message, TLAbsInputMedia media,
            TLAbsReplyMarkup replyMarkup, TLVector<TLAbsMessageEntity> entities,
            TLAbsInputGeoPoint geoPoint, long requestId, int botId) throws RpcErrorException,
            IOException {
        return (TLBotUpdates) executeRpcQuery(new TLRequestMonobotEditInlineBotMessage(noWebpage, stopGeoLive, id, message, media, replyMarkup, entities, geoPoint, requestId, botId));
    }

    @Override
    public TLBotUpdates monobotEditMessage(boolean noWebpage, boolean stopGeoLive,
            TLAbsInputPeer peer, int id, String message, TLAbsInputMedia media,
            TLAbsReplyMarkup replyMarkup, TLVector<TLAbsMessageEntity> entities,
            TLAbsInputGeoPoint geoPoint, long requestId, int botId) throws RpcErrorException,
            IOException {
        return (TLBotUpdates) executeRpcQuery(new TLRequestMonobotEditMessage(noWebpage, stopGeoLive, peer, id, message, media, replyMarkup, entities, geoPoint, requestId, botId));
    }

    @Override
    public TLBotUpdates monobotForwardMessages(boolean silent, boolean background,
            boolean withMyScore, boolean grouped, TLAbsInputPeer fromPeer, TLIntVector id,
            TLLongVector randomId, TLAbsInputPeer toPeer, long requestId, int botId) throws
            RpcErrorException, IOException {
        return (TLBotUpdates) executeRpcQuery(new TLRequestMonobotForwardMessages(silent, background, withMyScore, grouped, fromPeer, id, randomId, toPeer, requestId, botId));
    }

    @Override
    public TLBotUpdates monobotMessagesSetTyping(TLAbsInputPeer peer, TLAbsSendMessageAction action,
            long requestId, int botId) throws RpcErrorException, IOException {
        return (TLBotUpdates) executeRpcQuery(new TLRequestMonobotMessagesSetTyping(peer, action, requestId, botId));
    }

    @Override
    public TLBotUpdates monobotSendMedia(boolean silent, boolean background, boolean clearDraft,
            TLAbsInputPeer peer, Integer replyToMsgId, TLAbsInputMedia media, String message,
            long randomId, TLAbsReplyMarkup replyMarkup, TLVector<TLAbsMessageEntity> entities,
            long requestId, int botId) throws RpcErrorException, IOException {
        return (TLBotUpdates) executeRpcQuery(new TLRequestMonobotSendMedia(silent, background, clearDraft, peer, replyToMsgId, media, message, randomId, replyMarkup, entities, requestId, botId));
    }

    @Override
    public TLBotUpdates monobotSendMessage(boolean noWebpage, boolean silent, boolean background,
            boolean clearDraft, TLAbsInputPeer peer, Integer replyToMsgId, String message,
            long randomId, TLAbsReplyMarkup replyMarkup, TLVector<TLAbsMessageEntity> entities,
            long requestId, int botId) throws RpcErrorException, IOException {
        return (TLBotUpdates) executeRpcQuery(new TLRequestMonobotSendMessage(noWebpage, silent, background, clearDraft, peer, replyToMsgId, message, randomId, replyMarkup, entities, requestId, botId));
    }

    @Override
    public TLBotUpdates monobotSetBotCallbackAnswer(boolean alert, long queryId, String message,
            String url, int cacheTime, long requestId, int botId) throws RpcErrorException,
            IOException {
        return (TLBotUpdates) executeRpcQuery(new TLRequestMonobotSetBotCallbackAnswer(alert, queryId, message, url, cacheTime, requestId, botId));
    }

    @Override
    public TLBotUpdates monobotSignUp(String botName, String userName, long requestId) throws
            RpcErrorException, IOException {
        return (TLBotUpdates) executeRpcQuery(new TLRequestMonobotSignUp(botName, userName, requestId));
    }

    @Override
    public TLBotFile monobotUploadGetFile(TLAbsInputFileLocation location, int offset, int limit,
            long requestId, int botId) throws RpcErrorException, IOException {
        return (TLBotFile) executeRpcQuery(new TLRequestMonobotUploadGetFile(location, offset, limit, requestId, botId));
    }

    @Override
    public TLBool paymentsClearSavedInfo(boolean credentials, boolean info) throws
            RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestPaymentsClearSavedInfo(credentials, info));
    }

    @Override
    public TLPaymentForm paymentsGetPaymentForm(int msgId) throws RpcErrorException, IOException {
        return (TLPaymentForm) executeRpcQuery(new TLRequestPaymentsGetPaymentForm(msgId));
    }

    @Override
    public TLPaymentReceipt paymentsGetPaymentReceipt(int msgId) throws RpcErrorException,
            IOException {
        return (TLPaymentReceipt) executeRpcQuery(new TLRequestPaymentsGetPaymentReceipt(msgId));
    }

    @Override
    public TLSavedInfo paymentsGetSavedInfo() throws RpcErrorException, IOException {
        return (TLSavedInfo) executeRpcQuery(new TLRequestPaymentsGetSavedInfo());
    }

    @Override
    public TLAbsPaymentResult paymentsSendPaymentForm(int msgId, String requestedInfoId,
            String shippingOptionId, TLAbsInputPaymentCredentials credentials) throws
            RpcErrorException, IOException {
        return (TLAbsPaymentResult) executeRpcQuery(new TLRequestPaymentsSendPaymentForm(msgId, requestedInfoId, shippingOptionId, credentials));
    }

    @Override
    public TLValidatedRequestedInfo paymentsValidateRequestedInfo(boolean save, int msgId,
            TLPaymentRequestedInfo info) throws RpcErrorException, IOException {
        return (TLValidatedRequestedInfo) executeRpcQuery(new TLRequestPaymentsValidateRequestedInfo(save, msgId, info));
    }

    @Override
    public TLPhoneCall phoneAcceptCall(TLInputPhoneCall peer, TLBytes gB,
            TLPhoneCallProtocol protocol) throws RpcErrorException, IOException {
        return (TLPhoneCall) executeRpcQuery(new TLRequestPhoneAcceptCall(peer, gB, protocol));
    }

    @Override
    public TLPhoneCall phoneConfirmCall(TLInputPhoneCall peer, TLBytes gA, long keyFingerprint,
            TLPhoneCallProtocol protocol) throws RpcErrorException, IOException {
        return (TLPhoneCall) executeRpcQuery(new TLRequestPhoneConfirmCall(peer, gA, keyFingerprint, protocol));
    }

    @Override
    public TLAbsUpdates phoneDiscardCall(TLInputPhoneCall peer, int duration,
            TLAbsPhoneCallDiscardReason reason, long connectionId) throws RpcErrorException,
            IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestPhoneDiscardCall(peer, duration, reason, connectionId));
    }

    @Override
    public TLDataJSON phoneGetCallConfig() throws RpcErrorException, IOException {
        return (TLDataJSON) executeRpcQuery(new TLRequestPhoneGetCallConfig());
    }

    @Override
    public TLBool phoneReceivedCall(TLInputPhoneCall peer) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestPhoneReceivedCall(peer));
    }

    @Override
    public TLPhoneCall phoneRequestCall(TLAbsInputUser userId, int randomId, TLBytes gAHash,
            TLPhoneCallProtocol protocol) throws RpcErrorException, IOException {
        return (TLPhoneCall) executeRpcQuery(new TLRequestPhoneRequestCall(userId, randomId, gAHash, protocol));
    }

    @Override
    public TLBool phoneSaveCallDebug(TLInputPhoneCall peer, TLDataJSON debug) throws
            RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestPhoneSaveCallDebug(peer, debug));
    }

    @Override
    public TLAbsUpdates phoneSetCallRating(TLInputPhoneCall peer, int rating, String comment) throws
            RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestPhoneSetCallRating(peer, rating, comment));
    }

    @Override
    public TLLongVector photosDeletePhotos(TLVector<TLAbsInputPhoto> id) throws RpcErrorException,
            IOException {
        return (TLLongVector) executeRpcQuery(new TLRequestPhotosDeletePhotos(id));
    }

    @Override
    public TLAbsPhotos photosGetUserPhotos(TLAbsInputUser userId, int offset, long maxId, int limit)
            throws RpcErrorException, IOException {
        return (TLAbsPhotos) executeRpcQuery(new TLRequestPhotosGetUserPhotos(userId, offset, maxId, limit));
    }

    @Override
    public TLAbsUserProfilePhoto photosUpdateProfilePhoto(TLAbsInputPhoto id) throws
            RpcErrorException, IOException {
        return (TLAbsUserProfilePhoto) executeRpcQuery(new TLRequestPhotosUpdateProfilePhoto(id));
    }

    @Override
    public TLPhoto photosUploadProfilePhoto(TLAbsInputFile file) throws RpcErrorException,
            IOException {
        return (TLPhoto) executeRpcQuery(new TLRequestPhotosUploadProfilePhoto(file));
    }

    @Override
    public TLStickerSet stickersAddStickerToSet(TLAbsInputStickerSet stickerset,
            TLInputStickerSetItem sticker) throws RpcErrorException, IOException {
        return (TLStickerSet) executeRpcQuery(new TLRequestStickersAddStickerToSet(stickerset, sticker));
    }

    @Override
    public TLStickerSet stickersChangeStickerPosition(TLAbsInputDocument sticker, int position)
            throws RpcErrorException, IOException {
        return (TLStickerSet) executeRpcQuery(new TLRequestStickersChangeStickerPosition(sticker, position));
    }

    @Override
    public TLStickerSet stickersCreateStickerSet(boolean masks, TLAbsInputUser userId, String title,
            String shortName, TLVector<TLInputStickerSetItem> stickers) throws RpcErrorException,
            IOException {
        return (TLStickerSet) executeRpcQuery(new TLRequestStickersCreateStickerSet(masks, userId, title, shortName, stickers));
    }

    @Override
    public TLStickerSet stickersRemoveStickerFromSet(TLAbsInputDocument sticker) throws
            RpcErrorException, IOException {
        return (TLStickerSet) executeRpcQuery(new TLRequestStickersRemoveStickerFromSet(sticker));
    }

    @Override
    public TLAbsChannelDifference updatesGetChannelDifference(boolean force,
            TLAbsInputChannel channel, TLAbsChannelMessagesFilter filter, int pts, int limit) throws
            RpcErrorException, IOException {
        return (TLAbsChannelDifference) executeRpcQuery(new TLRequestUpdatesGetChannelDifference(force, channel, filter, pts, limit));
    }

    @Override
    public TLAbsDifference updatesGetDifference(int pts, Integer ptsTotalLimit, int date, int qts)
            throws RpcErrorException, IOException {
        return (TLAbsDifference) executeRpcQuery(new TLRequestUpdatesGetDifference(pts, ptsTotalLimit, date, qts));
    }

    @Override
    public TLState updatesGetState() throws RpcErrorException, IOException {
        return (TLState) executeRpcQuery(new TLRequestUpdatesGetState());
    }

    @Override
    public TLAbsCdnFile uploadGetCdnFile(TLBytes fileToken, int offset, int limit) throws
            RpcErrorException, IOException {
        return (TLAbsCdnFile) executeRpcQuery(new TLRequestUploadGetCdnFile(fileToken, offset, limit));
    }

    @Override
    public TLVector<TLFileHash> uploadGetCdnFileHashes(TLBytes fileToken, int offset) throws
            RpcErrorException, IOException {
        return (TLVector<TLFileHash>) executeRpcQuery(new TLRequestUploadGetCdnFileHashes(fileToken, offset));
    }

    @Override
    public TLAbsFile uploadGetFile(TLAbsInputFileLocation location, int offset, int limit) throws
            RpcErrorException, IOException {
        return (TLAbsFile) executeRpcQuery(new TLRequestUploadGetFile(location, offset, limit));
    }

    @Override
    public TLVector<TLFileHash> uploadGetFileHashes(TLAbsInputFileLocation location, int offset)
            throws RpcErrorException, IOException {
        return (TLVector<TLFileHash>) executeRpcQuery(new TLRequestUploadGetFileHashes(location, offset));
    }

    @Override
    public TLWebFile uploadGetWebFile(TLAbsInputWebFileLocation location, int offset, int limit)
            throws RpcErrorException, IOException {
        return (TLWebFile) executeRpcQuery(new TLRequestUploadGetWebFile(location, offset, limit));
    }

    @Override
    public TLVector<TLFileHash> uploadReuploadCdnFile(TLBytes fileToken, TLBytes requestToken)
            throws RpcErrorException, IOException {
        return (TLVector<TLFileHash>) executeRpcQuery(new TLRequestUploadReuploadCdnFile(fileToken, requestToken));
    }

    @Override
    public TLBool uploadSaveBigFilePart(long fileId, int filePart, int fileTotalParts,
            TLBytes bytes) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestUploadSaveBigFilePart(fileId, filePart, fileTotalParts, bytes));
    }

    @Override
    public TLBool uploadSaveFilePart(long fileId, int filePart, TLBytes bytes) throws
            RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestUploadSaveFilePart(fileId, filePart, bytes));
    }

    @Override
    public TLUserFull usersGetFullUser(TLAbsInputUser id) throws RpcErrorException, IOException {
        return (TLUserFull) executeRpcQuery(new TLRequestUsersGetFullUser(id));
    }

    @Override
    public TLVector<TLAbsUser> usersGetUsers(TLVector<TLAbsInputUser> id) throws RpcErrorException,
            IOException {
        return (TLVector<TLAbsUser>) executeRpcQuery(new TLRequestUsersGetUsers(id));
    }

    @Override
    public TLBool usersSetSecureValueErrors(TLAbsInputUser id,
            TLVector<TLAbsSecureValueError> errors) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestUsersSetSecureValueErrors(id, errors));
    }
}

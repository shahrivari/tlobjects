package io.tlobjects.tl.api;

import static io.tlobjects.tl.StreamUtils.*;
import static io.tlobjects.tl.TLObjectUtils.*;

import io.tlobjects.tl.api.account.TLAuthorizationForm;
import io.tlobjects.tl.api.account.TLAuthorizations;
import io.tlobjects.tl.api.account.TLPassword;
import io.tlobjects.tl.api.account.TLPasswordInputSettings;
import io.tlobjects.tl.api.account.TLPasswordSettings;
import io.tlobjects.tl.api.account.TLPrivacyRules;
import io.tlobjects.tl.api.account.TLSentEmailCode;
import io.tlobjects.tl.api.account.TLTakeout;
import io.tlobjects.tl.api.account.TLTmpPassword;
import io.tlobjects.tl.api.account.TLWebAuthorizations;
import io.tlobjects.tl.api.auth.TLAuthorization;
import io.tlobjects.tl.api.auth.TLExportedAuthorization;
import io.tlobjects.tl.api.auth.TLPasswordRecovery;
import io.tlobjects.tl.api.auth.TLSentCode;
import io.tlobjects.tl.api.channels.TLAbsChannelParticipants;
import io.tlobjects.tl.api.channels.TLAdminLogResults;
import io.tlobjects.tl.api.channels.TLChannelParticipant;
import io.tlobjects.tl.api.contacts.TLAbsBlocked;
import io.tlobjects.tl.api.contacts.TLAbsContacts;
import io.tlobjects.tl.api.contacts.TLAbsTopPeers;
import io.tlobjects.tl.api.contacts.TLFound;
import io.tlobjects.tl.api.contacts.TLImportedContacts;
import io.tlobjects.tl.api.contacts.TLLink;
import io.tlobjects.tl.api.contacts.TLResolvedPeer;
import io.tlobjects.tl.api.help.TLAbsAppUpdate;
import io.tlobjects.tl.api.help.TLAbsDeepLinkInfo;
import io.tlobjects.tl.api.help.TLAbsPassportConfig;
import io.tlobjects.tl.api.help.TLAbsProxyData;
import io.tlobjects.tl.api.help.TLAbsTermsOfServiceUpdate;
import io.tlobjects.tl.api.help.TLInviteText;
import io.tlobjects.tl.api.help.TLRecentMeUrls;
import io.tlobjects.tl.api.help.TLSupport;
import io.tlobjects.tl.api.messages.TLAbsAllStickers;
import io.tlobjects.tl.api.messages.TLAbsChats;
import io.tlobjects.tl.api.messages.TLAbsDhConfig;
import io.tlobjects.tl.api.messages.TLAbsDialogs;
import io.tlobjects.tl.api.messages.TLAbsFavedStickers;
import io.tlobjects.tl.api.messages.TLAbsFeaturedStickers;
import io.tlobjects.tl.api.messages.TLAbsFoundStickerSets;
import io.tlobjects.tl.api.messages.TLAbsMessages;
import io.tlobjects.tl.api.messages.TLAbsRecentStickers;
import io.tlobjects.tl.api.messages.TLAbsSavedGifs;
import io.tlobjects.tl.api.messages.TLAbsSentEncryptedMessage;
import io.tlobjects.tl.api.messages.TLAbsStickerSetInstallResult;
import io.tlobjects.tl.api.messages.TLAbsStickers;
import io.tlobjects.tl.api.messages.TLAffectedHistory;
import io.tlobjects.tl.api.messages.TLAffectedMessages;
import io.tlobjects.tl.api.messages.TLArchivedStickers;
import io.tlobjects.tl.api.messages.TLBotCallbackAnswer;
import io.tlobjects.tl.api.messages.TLBotResults;
import io.tlobjects.tl.api.messages.TLChatFull;
import io.tlobjects.tl.api.messages.TLFoundGifs;
import io.tlobjects.tl.api.messages.TLHighScores;
import io.tlobjects.tl.api.messages.TLMessageEditData;
import io.tlobjects.tl.api.messages.TLPeerDialogs;
import io.tlobjects.tl.api.messages.TLStickerSet;
import io.tlobjects.tl.api.payments.TLAbsPaymentResult;
import io.tlobjects.tl.api.payments.TLPaymentForm;
import io.tlobjects.tl.api.payments.TLPaymentReceipt;
import io.tlobjects.tl.api.payments.TLSavedInfo;
import io.tlobjects.tl.api.payments.TLValidatedRequestedInfo;
import io.tlobjects.tl.api.phone.TLPhoneCall;
import io.tlobjects.tl.api.photos.TLAbsPhotos;
import io.tlobjects.tl.api.photos.TLPhoto;
import io.tlobjects.tl.api.request.TLRequestAccountAcceptAuthorization;
import io.tlobjects.tl.api.request.TLRequestAccountChangePhone;
import io.tlobjects.tl.api.request.TLRequestAccountCheckUsername;
import io.tlobjects.tl.api.request.TLRequestAccountConfirmPhone;
import io.tlobjects.tl.api.request.TLRequestAccountDeleteAccount;
import io.tlobjects.tl.api.request.TLRequestAccountDeleteSecureValue;
import io.tlobjects.tl.api.request.TLRequestAccountFinishTakeoutSession;
import io.tlobjects.tl.api.request.TLRequestAccountGetAccountTTL;
import io.tlobjects.tl.api.request.TLRequestAccountGetAllSecureValues;
import io.tlobjects.tl.api.request.TLRequestAccountGetAuthorizationForm;
import io.tlobjects.tl.api.request.TLRequestAccountGetAuthorizations;
import io.tlobjects.tl.api.request.TLRequestAccountGetNotifySettings;
import io.tlobjects.tl.api.request.TLRequestAccountGetPassword;
import io.tlobjects.tl.api.request.TLRequestAccountGetPasswordSettings;
import io.tlobjects.tl.api.request.TLRequestAccountGetPrivacy;
import io.tlobjects.tl.api.request.TLRequestAccountGetSecureValue;
import io.tlobjects.tl.api.request.TLRequestAccountGetTmpPassword;
import io.tlobjects.tl.api.request.TLRequestAccountGetWallPapers;
import io.tlobjects.tl.api.request.TLRequestAccountGetWebAuthorizations;
import io.tlobjects.tl.api.request.TLRequestAccountInitTakeoutSession;
import io.tlobjects.tl.api.request.TLRequestAccountRegisterDevice;
import io.tlobjects.tl.api.request.TLRequestAccountReportPeer;
import io.tlobjects.tl.api.request.TLRequestAccountResetAuthorization;
import io.tlobjects.tl.api.request.TLRequestAccountResetNotifySettings;
import io.tlobjects.tl.api.request.TLRequestAccountResetWebAuthorization;
import io.tlobjects.tl.api.request.TLRequestAccountResetWebAuthorizations;
import io.tlobjects.tl.api.request.TLRequestAccountSaveSecureValue;
import io.tlobjects.tl.api.request.TLRequestAccountSendChangePhoneCode;
import io.tlobjects.tl.api.request.TLRequestAccountSendConfirmPhoneCode;
import io.tlobjects.tl.api.request.TLRequestAccountSendVerifyEmailCode;
import io.tlobjects.tl.api.request.TLRequestAccountSendVerifyPhoneCode;
import io.tlobjects.tl.api.request.TLRequestAccountSetAccountTTL;
import io.tlobjects.tl.api.request.TLRequestAccountSetPrivacy;
import io.tlobjects.tl.api.request.TLRequestAccountUnregisterDevice;
import io.tlobjects.tl.api.request.TLRequestAccountUpdateDeviceLocked;
import io.tlobjects.tl.api.request.TLRequestAccountUpdateNotifySettings;
import io.tlobjects.tl.api.request.TLRequestAccountUpdatePasswordSettings;
import io.tlobjects.tl.api.request.TLRequestAccountUpdateProfile;
import io.tlobjects.tl.api.request.TLRequestAccountUpdateStatus;
import io.tlobjects.tl.api.request.TLRequestAccountUpdateUsername;
import io.tlobjects.tl.api.request.TLRequestAccountVerifyEmail;
import io.tlobjects.tl.api.request.TLRequestAccountVerifyPhone;
import io.tlobjects.tl.api.request.TLRequestAuthBindTempAuthKey;
import io.tlobjects.tl.api.request.TLRequestAuthCancelCode;
import io.tlobjects.tl.api.request.TLRequestAuthCheckPassword;
import io.tlobjects.tl.api.request.TLRequestAuthDropTempAuthKeys;
import io.tlobjects.tl.api.request.TLRequestAuthExportAuthorization;
import io.tlobjects.tl.api.request.TLRequestAuthImportAuthorization;
import io.tlobjects.tl.api.request.TLRequestAuthImportBotAuthorization;
import io.tlobjects.tl.api.request.TLRequestAuthLogOut;
import io.tlobjects.tl.api.request.TLRequestAuthRecoverPassword;
import io.tlobjects.tl.api.request.TLRequestAuthRequestPasswordRecovery;
import io.tlobjects.tl.api.request.TLRequestAuthResendCode;
import io.tlobjects.tl.api.request.TLRequestAuthResetAuthorizations;
import io.tlobjects.tl.api.request.TLRequestAuthSendCode;
import io.tlobjects.tl.api.request.TLRequestAuthSignIn;
import io.tlobjects.tl.api.request.TLRequestAuthSignUp;
import io.tlobjects.tl.api.request.TLRequestBotsAnswerWebhookJSONQuery;
import io.tlobjects.tl.api.request.TLRequestBotsSendCustomRequest;
import io.tlobjects.tl.api.request.TLRequestChannelsCheckUsername;
import io.tlobjects.tl.api.request.TLRequestChannelsCreateChannel;
import io.tlobjects.tl.api.request.TLRequestChannelsDeleteChannel;
import io.tlobjects.tl.api.request.TLRequestChannelsDeleteHistory;
import io.tlobjects.tl.api.request.TLRequestChannelsDeleteMessages;
import io.tlobjects.tl.api.request.TLRequestChannelsDeleteUserHistory;
import io.tlobjects.tl.api.request.TLRequestChannelsEditAbout;
import io.tlobjects.tl.api.request.TLRequestChannelsEditAdmin;
import io.tlobjects.tl.api.request.TLRequestChannelsEditBanned;
import io.tlobjects.tl.api.request.TLRequestChannelsEditPhoto;
import io.tlobjects.tl.api.request.TLRequestChannelsEditTitle;
import io.tlobjects.tl.api.request.TLRequestChannelsExportInvite;
import io.tlobjects.tl.api.request.TLRequestChannelsExportMessageLink;
import io.tlobjects.tl.api.request.TLRequestChannelsGetAdminLog;
import io.tlobjects.tl.api.request.TLRequestChannelsGetAdminedPublicChannels;
import io.tlobjects.tl.api.request.TLRequestChannelsGetChannels;
import io.tlobjects.tl.api.request.TLRequestChannelsGetFullChannel;
import io.tlobjects.tl.api.request.TLRequestChannelsGetLeftChannels;
import io.tlobjects.tl.api.request.TLRequestChannelsGetMessages;
import io.tlobjects.tl.api.request.TLRequestChannelsGetParticipant;
import io.tlobjects.tl.api.request.TLRequestChannelsGetParticipants;
import io.tlobjects.tl.api.request.TLRequestChannelsInviteToChannel;
import io.tlobjects.tl.api.request.TLRequestChannelsJoinChannel;
import io.tlobjects.tl.api.request.TLRequestChannelsLeaveChannel;
import io.tlobjects.tl.api.request.TLRequestChannelsReadHistory;
import io.tlobjects.tl.api.request.TLRequestChannelsReadMessageContents;
import io.tlobjects.tl.api.request.TLRequestChannelsReportSpam;
import io.tlobjects.tl.api.request.TLRequestChannelsSetStickers;
import io.tlobjects.tl.api.request.TLRequestChannelsToggleInvites;
import io.tlobjects.tl.api.request.TLRequestChannelsTogglePreHistoryHidden;
import io.tlobjects.tl.api.request.TLRequestChannelsToggleSignatures;
import io.tlobjects.tl.api.request.TLRequestChannelsUpdatePinnedMessage;
import io.tlobjects.tl.api.request.TLRequestChannelsUpdateUsername;
import io.tlobjects.tl.api.request.TLRequestContactsBlock;
import io.tlobjects.tl.api.request.TLRequestContactsDeleteContact;
import io.tlobjects.tl.api.request.TLRequestContactsDeleteContacts;
import io.tlobjects.tl.api.request.TLRequestContactsExportCard;
import io.tlobjects.tl.api.request.TLRequestContactsGetBlocked;
import io.tlobjects.tl.api.request.TLRequestContactsGetContacts;
import io.tlobjects.tl.api.request.TLRequestContactsGetSaved;
import io.tlobjects.tl.api.request.TLRequestContactsGetStatuses;
import io.tlobjects.tl.api.request.TLRequestContactsGetTopPeers;
import io.tlobjects.tl.api.request.TLRequestContactsImportCard;
import io.tlobjects.tl.api.request.TLRequestContactsImportContacts;
import io.tlobjects.tl.api.request.TLRequestContactsResetSaved;
import io.tlobjects.tl.api.request.TLRequestContactsResetTopPeerRating;
import io.tlobjects.tl.api.request.TLRequestContactsResolveUsername;
import io.tlobjects.tl.api.request.TLRequestContactsSearch;
import io.tlobjects.tl.api.request.TLRequestContactsToggleTopPeers;
import io.tlobjects.tl.api.request.TLRequestContactsUnblock;
import io.tlobjects.tl.api.request.TLRequestHelpAcceptTermsOfService;
import io.tlobjects.tl.api.request.TLRequestHelpGetAppChangelog;
import io.tlobjects.tl.api.request.TLRequestHelpGetAppUpdate;
import io.tlobjects.tl.api.request.TLRequestHelpGetCdnConfig;
import io.tlobjects.tl.api.request.TLRequestHelpGetConfig;
import io.tlobjects.tl.api.request.TLRequestHelpGetDeepLinkInfo;
import io.tlobjects.tl.api.request.TLRequestHelpGetInviteText;
import io.tlobjects.tl.api.request.TLRequestHelpGetNearestDc;
import io.tlobjects.tl.api.request.TLRequestHelpGetPassportConfig;
import io.tlobjects.tl.api.request.TLRequestHelpGetProxyData;
import io.tlobjects.tl.api.request.TLRequestHelpGetRecentMeUrls;
import io.tlobjects.tl.api.request.TLRequestHelpGetSupport;
import io.tlobjects.tl.api.request.TLRequestHelpGetTermsOfServiceUpdate;
import io.tlobjects.tl.api.request.TLRequestHelpSaveAppLog;
import io.tlobjects.tl.api.request.TLRequestHelpSetBotUpdatesStatus;
import io.tlobjects.tl.api.request.TLRequestInitConnection;
import io.tlobjects.tl.api.request.TLRequestInvokeAfterMsg;
import io.tlobjects.tl.api.request.TLRequestInvokeAfterMsgs;
import io.tlobjects.tl.api.request.TLRequestInvokeWithLayer;
import io.tlobjects.tl.api.request.TLRequestInvokeWithMessagesRange;
import io.tlobjects.tl.api.request.TLRequestInvokeWithTakeout;
import io.tlobjects.tl.api.request.TLRequestInvokeWithoutUpdates;
import io.tlobjects.tl.api.request.TLRequestLangpackGetDifference;
import io.tlobjects.tl.api.request.TLRequestLangpackGetLangPack;
import io.tlobjects.tl.api.request.TLRequestLangpackGetLanguages;
import io.tlobjects.tl.api.request.TLRequestLangpackGetStrings;
import io.tlobjects.tl.api.request.TLRequestMessagesAcceptEncryption;
import io.tlobjects.tl.api.request.TLRequestMessagesAddChatUser;
import io.tlobjects.tl.api.request.TLRequestMessagesCheckChatInvite;
import io.tlobjects.tl.api.request.TLRequestMessagesClearAllDrafts;
import io.tlobjects.tl.api.request.TLRequestMessagesClearRecentStickers;
import io.tlobjects.tl.api.request.TLRequestMessagesCreateChat;
import io.tlobjects.tl.api.request.TLRequestMessagesDeleteChatUser;
import io.tlobjects.tl.api.request.TLRequestMessagesDeleteHistory;
import io.tlobjects.tl.api.request.TLRequestMessagesDeleteMessages;
import io.tlobjects.tl.api.request.TLRequestMessagesDiscardEncryption;
import io.tlobjects.tl.api.request.TLRequestMessagesEditChatAdmin;
import io.tlobjects.tl.api.request.TLRequestMessagesEditChatPhoto;
import io.tlobjects.tl.api.request.TLRequestMessagesEditChatTitle;
import io.tlobjects.tl.api.request.TLRequestMessagesEditInlineBotMessage;
import io.tlobjects.tl.api.request.TLRequestMessagesEditMessage;
import io.tlobjects.tl.api.request.TLRequestMessagesExportChatInvite;
import io.tlobjects.tl.api.request.TLRequestMessagesFaveSticker;
import io.tlobjects.tl.api.request.TLRequestMessagesForwardMessages;
import io.tlobjects.tl.api.request.TLRequestMessagesGetAllChats;
import io.tlobjects.tl.api.request.TLRequestMessagesGetAllDrafts;
import io.tlobjects.tl.api.request.TLRequestMessagesGetAllStickers;
import io.tlobjects.tl.api.request.TLRequestMessagesGetArchivedStickers;
import io.tlobjects.tl.api.request.TLRequestMessagesGetAttachedStickers;
import io.tlobjects.tl.api.request.TLRequestMessagesGetBotCallbackAnswer;
import io.tlobjects.tl.api.request.TLRequestMessagesGetChats;
import io.tlobjects.tl.api.request.TLRequestMessagesGetCommonChats;
import io.tlobjects.tl.api.request.TLRequestMessagesGetDhConfig;
import io.tlobjects.tl.api.request.TLRequestMessagesGetDialogUnreadMarks;
import io.tlobjects.tl.api.request.TLRequestMessagesGetDialogs;
import io.tlobjects.tl.api.request.TLRequestMessagesGetDocumentByHash;
import io.tlobjects.tl.api.request.TLRequestMessagesGetFavedStickers;
import io.tlobjects.tl.api.request.TLRequestMessagesGetFeaturedStickers;
import io.tlobjects.tl.api.request.TLRequestMessagesGetFullChat;
import io.tlobjects.tl.api.request.TLRequestMessagesGetGameHighScores;
import io.tlobjects.tl.api.request.TLRequestMessagesGetHistory;
import io.tlobjects.tl.api.request.TLRequestMessagesGetInlineBotResults;
import io.tlobjects.tl.api.request.TLRequestMessagesGetInlineGameHighScores;
import io.tlobjects.tl.api.request.TLRequestMessagesGetMaskStickers;
import io.tlobjects.tl.api.request.TLRequestMessagesGetMessageEditData;
import io.tlobjects.tl.api.request.TLRequestMessagesGetMessages;
import io.tlobjects.tl.api.request.TLRequestMessagesGetMessagesViews;
import io.tlobjects.tl.api.request.TLRequestMessagesGetPeerDialogs;
import io.tlobjects.tl.api.request.TLRequestMessagesGetPeerSettings;
import io.tlobjects.tl.api.request.TLRequestMessagesGetPinnedDialogs;
import io.tlobjects.tl.api.request.TLRequestMessagesGetRecentLocations;
import io.tlobjects.tl.api.request.TLRequestMessagesGetRecentStickers;
import io.tlobjects.tl.api.request.TLRequestMessagesGetSavedGifs;
import io.tlobjects.tl.api.request.TLRequestMessagesGetSplitRanges;
import io.tlobjects.tl.api.request.TLRequestMessagesGetStickerSet;
import io.tlobjects.tl.api.request.TLRequestMessagesGetStickers;
import io.tlobjects.tl.api.request.TLRequestMessagesGetUnreadMentions;
import io.tlobjects.tl.api.request.TLRequestMessagesGetWebPage;
import io.tlobjects.tl.api.request.TLRequestMessagesGetWebPagePreview;
import io.tlobjects.tl.api.request.TLRequestMessagesHideReportSpam;
import io.tlobjects.tl.api.request.TLRequestMessagesImportChatInvite;
import io.tlobjects.tl.api.request.TLRequestMessagesInstallStickerSet;
import io.tlobjects.tl.api.request.TLRequestMessagesMarkDialogUnread;
import io.tlobjects.tl.api.request.TLRequestMessagesMigrateChat;
import io.tlobjects.tl.api.request.TLRequestMessagesReadEncryptedHistory;
import io.tlobjects.tl.api.request.TLRequestMessagesReadFeaturedStickers;
import io.tlobjects.tl.api.request.TLRequestMessagesReadHistory;
import io.tlobjects.tl.api.request.TLRequestMessagesReadMentions;
import io.tlobjects.tl.api.request.TLRequestMessagesReadMessageContents;
import io.tlobjects.tl.api.request.TLRequestMessagesReceivedMessages;
import io.tlobjects.tl.api.request.TLRequestMessagesReceivedQueue;
import io.tlobjects.tl.api.request.TLRequestMessagesReorderPinnedDialogs;
import io.tlobjects.tl.api.request.TLRequestMessagesReorderStickerSets;
import io.tlobjects.tl.api.request.TLRequestMessagesReport;
import io.tlobjects.tl.api.request.TLRequestMessagesReportEncryptedSpam;
import io.tlobjects.tl.api.request.TLRequestMessagesReportSpam;
import io.tlobjects.tl.api.request.TLRequestMessagesRequestEncryption;
import io.tlobjects.tl.api.request.TLRequestMessagesSaveDraft;
import io.tlobjects.tl.api.request.TLRequestMessagesSaveGif;
import io.tlobjects.tl.api.request.TLRequestMessagesSaveRecentSticker;
import io.tlobjects.tl.api.request.TLRequestMessagesSearch;
import io.tlobjects.tl.api.request.TLRequestMessagesSearchGifs;
import io.tlobjects.tl.api.request.TLRequestMessagesSearchGlobal;
import io.tlobjects.tl.api.request.TLRequestMessagesSearchStickerSets;
import io.tlobjects.tl.api.request.TLRequestMessagesSendEncrypted;
import io.tlobjects.tl.api.request.TLRequestMessagesSendEncryptedFile;
import io.tlobjects.tl.api.request.TLRequestMessagesSendEncryptedService;
import io.tlobjects.tl.api.request.TLRequestMessagesSendInlineBotResult;
import io.tlobjects.tl.api.request.TLRequestMessagesSendMedia;
import io.tlobjects.tl.api.request.TLRequestMessagesSendMessage;
import io.tlobjects.tl.api.request.TLRequestMessagesSendMultiMedia;
import io.tlobjects.tl.api.request.TLRequestMessagesSendScreenshotNotification;
import io.tlobjects.tl.api.request.TLRequestMessagesSetBotCallbackAnswer;
import io.tlobjects.tl.api.request.TLRequestMessagesSetBotPrecheckoutResults;
import io.tlobjects.tl.api.request.TLRequestMessagesSetBotShippingResults;
import io.tlobjects.tl.api.request.TLRequestMessagesSetEncryptedTyping;
import io.tlobjects.tl.api.request.TLRequestMessagesSetGameScore;
import io.tlobjects.tl.api.request.TLRequestMessagesSetInlineBotResults;
import io.tlobjects.tl.api.request.TLRequestMessagesSetInlineGameScore;
import io.tlobjects.tl.api.request.TLRequestMessagesSetTyping;
import io.tlobjects.tl.api.request.TLRequestMessagesStartBot;
import io.tlobjects.tl.api.request.TLRequestMessagesToggleChatAdmins;
import io.tlobjects.tl.api.request.TLRequestMessagesToggleDialogPin;
import io.tlobjects.tl.api.request.TLRequestMessagesUninstallStickerSet;
import io.tlobjects.tl.api.request.TLRequestMessagesUploadEncryptedFile;
import io.tlobjects.tl.api.request.TLRequestMessagesUploadMedia;
import io.tlobjects.tl.api.request.TLRequestPaymentsClearSavedInfo;
import io.tlobjects.tl.api.request.TLRequestPaymentsGetPaymentForm;
import io.tlobjects.tl.api.request.TLRequestPaymentsGetPaymentReceipt;
import io.tlobjects.tl.api.request.TLRequestPaymentsGetSavedInfo;
import io.tlobjects.tl.api.request.TLRequestPaymentsSendPaymentForm;
import io.tlobjects.tl.api.request.TLRequestPaymentsValidateRequestedInfo;
import io.tlobjects.tl.api.request.TLRequestPhoneAcceptCall;
import io.tlobjects.tl.api.request.TLRequestPhoneConfirmCall;
import io.tlobjects.tl.api.request.TLRequestPhoneDiscardCall;
import io.tlobjects.tl.api.request.TLRequestPhoneGetCallConfig;
import io.tlobjects.tl.api.request.TLRequestPhoneReceivedCall;
import io.tlobjects.tl.api.request.TLRequestPhoneRequestCall;
import io.tlobjects.tl.api.request.TLRequestPhoneSaveCallDebug;
import io.tlobjects.tl.api.request.TLRequestPhoneSetCallRating;
import io.tlobjects.tl.api.request.TLRequestPhotosDeletePhotos;
import io.tlobjects.tl.api.request.TLRequestPhotosGetUserPhotos;
import io.tlobjects.tl.api.request.TLRequestPhotosUpdateProfilePhoto;
import io.tlobjects.tl.api.request.TLRequestPhotosUploadProfilePhoto;
import io.tlobjects.tl.api.request.TLRequestStickersAddStickerToSet;
import io.tlobjects.tl.api.request.TLRequestStickersChangeStickerPosition;
import io.tlobjects.tl.api.request.TLRequestStickersCreateStickerSet;
import io.tlobjects.tl.api.request.TLRequestStickersRemoveStickerFromSet;
import io.tlobjects.tl.api.request.TLRequestUpdatesGetChannelDifference;
import io.tlobjects.tl.api.request.TLRequestUpdatesGetDifference;
import io.tlobjects.tl.api.request.TLRequestUpdatesGetState;
import io.tlobjects.tl.api.request.TLRequestUploadGetCdnFile;
import io.tlobjects.tl.api.request.TLRequestUploadGetCdnFileHashes;
import io.tlobjects.tl.api.request.TLRequestUploadGetFile;
import io.tlobjects.tl.api.request.TLRequestUploadGetFileHashes;
import io.tlobjects.tl.api.request.TLRequestUploadGetWebFile;
import io.tlobjects.tl.api.request.TLRequestUploadReuploadCdnFile;
import io.tlobjects.tl.api.request.TLRequestUploadSaveBigFilePart;
import io.tlobjects.tl.api.request.TLRequestUploadSaveFilePart;
import io.tlobjects.tl.api.request.TLRequestUsersGetFullUser;
import io.tlobjects.tl.api.request.TLRequestUsersGetUsers;
import io.tlobjects.tl.api.request.TLRequestUsersSetSecureValueErrors;
import io.tlobjects.tl.api.updates.TLAbsChannelDifference;
import io.tlobjects.tl.api.updates.TLAbsDifference;
import io.tlobjects.tl.api.updates.TLState;
import io.tlobjects.tl.api.upload.TLAbsCdnFile;
import io.tlobjects.tl.api.upload.TLAbsFile;
import io.tlobjects.tl.api.upload.TLWebFile;
import io.tlobjects.tl.core.TLBool;
import io.tlobjects.tl.core.TLBytes;
import io.tlobjects.tl.core.TLIntVector;
import io.tlobjects.tl.core.TLLongVector;
import io.tlobjects.tl.core.TLMethod;
import io.tlobjects.tl.core.TLObject;
import io.tlobjects.tl.core.TLStringVector;
import io.tlobjects.tl.core.TLVector;
import io.tlobjects.tl.exception.RpcErrorException;
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
    public TLAbsTermsOfServiceUpdate helpGetTermsOfServiceUpdate() throws RpcErrorException,
            IOException {
        return (TLAbsTermsOfServiceUpdate) executeRpcQuery(new TLRequestHelpGetTermsOfServiceUpdate());
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

package unsa.edu.pe.manualmoodle;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;


class UpdateHelper {

    public static final String KEY_UPDATE_REQUIRED = "force_update_required";
    public static final String KEY_CURRENT_VERSION = "force_update_current_version";
    public static final String KEY_UPDATE_URL = "force_update_store_url";

    public interface OnUpdateCheckListener {
        void onUpdateCheckListener(String updateUrl);
    }

    public static Builder with(@NonNull Context context) {
        return new Builder(context);
    }


    private OnUpdateCheckListener onUpdateNeededListener;
    private Context context;

    public UpdateHelper(@NonNull Context context,
                              OnUpdateCheckListener onUpdateNeededListener) {
        this.context = context;
        this.onUpdateNeededListener = onUpdateNeededListener;
    }

    public void check() {
        final FirebaseRemoteConfig remoteConfig = FirebaseRemoteConfig.getInstance();

        if (remoteConfig.getBoolean(KEY_UPDATE_REQUIRED)) {
            String currentVersion = remoteConfig.getString(KEY_CURRENT_VERSION);
            String appVersion = getAppVersion(context);
            String updateUrl = remoteConfig.getString(KEY_UPDATE_URL);

            if (!TextUtils.equals(currentVersion, appVersion)
                    && onUpdateNeededListener != null) {
                onUpdateNeededListener.onUpdateCheckListener(updateUrl);
            }
        }
    }

    private String getAppVersion(Context context) {
        String result = "";

        try {
            result = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0)
                    .versionName;
            result = result.replaceAll("[a-zA-Z]|-", "");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static class Builder {

        private Context context;
        private OnUpdateCheckListener onUpdateNeededListener;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder OnUpdateCheck(OnUpdateCheckListener onUpdateNeededListener) {
            this.onUpdateNeededListener = onUpdateNeededListener;
            return this;
        }

        public UpdateHelper build() {
            return new UpdateHelper(context, onUpdateNeededListener);
        }

        public UpdateHelper check() {
            UpdateHelper forceUpdateChecker = build();
            forceUpdateChecker.check();

            return forceUpdateChecker;
        }

    }
}

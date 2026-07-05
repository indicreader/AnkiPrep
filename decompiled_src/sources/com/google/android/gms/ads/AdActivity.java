package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbwt;
import com.google.android.gms.internal.ads.zzcec;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class AdActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    private zzbwt zza;

    private final void zza() {
        zzbwt zzbwtVar = this.zza;
        if (zzbwtVar != null) {
            try {
                zzbwtVar.zzx();
            } catch (RemoteException e) {
                zzcec.zzl("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // android.app.Activity
    protected final void onActivityResult(int i, int i2, Intent intent) {
        try {
            zzbwt zzbwtVar = this.zza;
            if (zzbwtVar != null) {
                zzbwtVar.zzh(i, i2, intent);
            }
        } catch (Exception e) {
            zzcec.zzl("#007 Could not call remote method.", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        try {
            zzbwt zzbwtVar = this.zza;
            if (zzbwtVar != null) {
                if (!zzbwtVar.zzH()) {
                    return;
                }
            }
        } catch (RemoteException e) {
            zzcec.zzl("#007 Could not call remote method.", e);
        }
        super.onBackPressed();
        try {
            zzbwt zzbwtVar2 = this.zza;
            if (zzbwtVar2 != null) {
                zzbwtVar2.zzi();
            }
        } catch (RemoteException e2) {
            zzcec.zzl("#007 Could not call remote method.", e2);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            zzbwt zzbwtVar = this.zza;
            if (zzbwtVar != null) {
                zzbwtVar.zzk(ObjectWrapper.wrap(configuration));
            }
        } catch (RemoteException e) {
            zzcec.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zzbwt zzo = zzay.zza().zzo(this);
        this.zza = zzo;
        if (zzo != null) {
            try {
                zzo.zzl(bundle);
                return;
            } catch (RemoteException e) {
                zzcec.zzl("#007 Could not call remote method.", e);
                finish();
                return;
            }
        }
        zzcec.zzl("#007 Could not call remote method.", null);
        finish();
    }

    @Override // android.app.Activity
    protected final void onDestroy() {
        try {
            zzbwt zzbwtVar = this.zza;
            if (zzbwtVar != null) {
                zzbwtVar.zzm();
            }
        } catch (RemoteException e) {
            zzcec.zzl("#007 Could not call remote method.", e);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected final void onPause() {
        try {
            zzbwt zzbwtVar = this.zza;
            if (zzbwtVar != null) {
                zzbwtVar.zzo();
            }
        } catch (RemoteException e) {
            zzcec.zzl("#007 Could not call remote method.", e);
            finish();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        try {
            zzbwt zzbwtVar = this.zza;
            if (zzbwtVar != null) {
                zzbwtVar.zzp(i, strArr, iArr);
            }
        } catch (RemoteException e) {
            zzcec.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // android.app.Activity
    protected final void onRestart() {
        super.onRestart();
        try {
            zzbwt zzbwtVar = this.zza;
            if (zzbwtVar != null) {
                zzbwtVar.zzq();
            }
        } catch (RemoteException e) {
            zzcec.zzl("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onResume() {
        super.onResume();
        try {
            zzbwt zzbwtVar = this.zza;
            if (zzbwtVar != null) {
                zzbwtVar.zzr();
            }
        } catch (RemoteException e) {
            zzcec.zzl("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onSaveInstanceState(Bundle bundle) {
        try {
            zzbwt zzbwtVar = this.zza;
            if (zzbwtVar != null) {
                zzbwtVar.zzs(bundle);
            }
        } catch (RemoteException e) {
            zzcec.zzl("#007 Could not call remote method.", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected final void onStart() {
        super.onStart();
        try {
            zzbwt zzbwtVar = this.zza;
            if (zzbwtVar != null) {
                zzbwtVar.zzt();
            }
        } catch (RemoteException e) {
            zzcec.zzl("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onStop() {
        try {
            zzbwt zzbwtVar = this.zza;
            if (zzbwtVar != null) {
                zzbwtVar.zzu();
            }
        } catch (RemoteException e) {
            zzcec.zzl("#007 Could not call remote method.", e);
            finish();
        }
        super.onStop();
    }

    @Override // android.app.Activity
    protected final void onUserLeaveHint() {
        super.onUserLeaveHint();
        try {
            zzbwt zzbwtVar = this.zza;
            if (zzbwtVar != null) {
                zzbwtVar.zzv();
            }
        } catch (RemoteException e) {
            zzcec.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // android.app.Activity
    public final void setContentView(int i) {
        super.setContentView(i);
        zza();
    }

    @Override // android.app.Activity
    public final void setContentView(View view) {
        super.setContentView(view);
        zza();
    }

    @Override // android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        zza();
    }
}

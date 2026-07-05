package org.checkerframework.checker.calledmethods.qual;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.PostconditionAnnotation;
import org.checkerframework.framework.qual.QualifierArgument;

@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@PostconditionAnnotation(qualifier = CalledMethods.class)
/* loaded from: classes4.dex */
public @interface EnsuresCalledMethods {
    @QualifierArgument(AppMeasurementSdk.ConditionalUserProperty.VALUE)
    String[] methods();

    String[] value();
}

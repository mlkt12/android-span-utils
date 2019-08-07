package com.mlkt.development.spanutils;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;

public class SpanUtils {


    public static Builder Builder(String s) {
        return new SpanUtils().new Builder(s);
    }

    public class Builder {

        private SpannableStringBuilder sb;


        private Builder(String s) {
            sb = new SpannableStringBuilder(s);
        }

        private void setSpan(Object what) {
            sb.setSpan(what, 0, sb.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        public Builder normal() {
            StyleSpan boldSpan = new StyleSpan(Typeface.NORMAL);
            setSpan(boldSpan);
            return this;
        }

        public Builder bold() {
            StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
            setSpan(boldSpan);
            return this;
        }

        public Builder itallic() {
            StyleSpan italicSpan = new StyleSpan(Typeface.ITALIC);
            setSpan(italicSpan);
            return this;
        }

        public Builder underline() {
            UnderlineSpan underlineSpan = new UnderlineSpan();
            setSpan(underlineSpan);
            return this;
        }

        public Builder color(int color) {
            ForegroundColorSpan colorSpan = new ForegroundColorSpan(color);
            setSpan(colorSpan);
            return this;
        }

        public Builder background(int color) {
            BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(color);
            setSpan(backgroundColorSpan);
            return this;
        }

        public Builder font(Context context, int fontId) {
            Typeface typeface = ResourcesCompat.getFont(context, fontId);
            setSpan(new CustomTypefaceSpan(typeface));
            return this;
        }

        public Builder size(int size) {
            AbsoluteSizeSpan sizeSpan = new AbsoluteSizeSpan(size, true);
            setSpan(sizeSpan);
            return this;
        }

        public CharSequence build(){
            return sb;
        }

    }

    public class CustomTypefaceSpan extends MetricAffectingSpan {

        private final Typeface typeface;

        public CustomTypefaceSpan(Typeface typeface) {
            this.typeface = typeface;
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            applyCustomTypeFace(ds, typeface);
        }

        @Override
        public void updateMeasureState(TextPaint paint) {
            applyCustomTypeFace(paint, typeface);
        }

        private void applyCustomTypeFace(Paint paint, Typeface tf) {
            paint.setTypeface(tf);
        }
    }
}

package com.luan.luxionary;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateActivity extends AppCompatActivity {
    // Data from DB
    String strNick, strPw, strName, strEmail, strAvatar;

    String[] monthKor = {"1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"};
    String[] monthEng = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    String[] monthFra = {"janvier", "février", "mars", "avril", "mai", "juin", "juillet", "août", "septembre", "octobre", "novembre", "décembre"};
    String[] monthDeu = {"Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"};
    String[] monthIta = {"gennaio", "febbraio", "marzo", "aprile", "maggio", "giugno", "luglio", "agosto", "settembre", "ottobre", "novembre", "dicembre"};
    String[] monthSpa = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
    String[] monthRus = {"январь", "февраль", "март", "апрель", "май", "июнь", "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь"};

    String[] doMKor = {"1일", "2일", "3일", "4일", "5일", "6일", "7일", "8일", "9일", "10일",
            "11일", "12일", "13일", "14일", "15일", "16일", "17일", "18일", "19일", "20일",
            "21일", "22일", "23일", "24일", "25일", "26일", "27일", "28일", "29일", "30일", "31일"};
    String[] doMEng = {"first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth",
            "eleventh", "twelfth", "thirteenth", "fourteenth", "fifteenth", "sixteenth", "seventeenth", "eighteenth", "nineteenth", "twentieth",
            "twenty-first", "twenty-second", "twenty-third", "twenty-fourth", "twenty-fifth", "twenty-sixth", "twenty-seventh", "twenty-eighth", "twenty-ninth", "thirtieth", "thirty-first"};
    String[] doMFra = {"le premier", "le deux", "le trois", "le quatre", "le cinq", "le six", "le sept", "le huit", "le neuf", "le dix",
            "le onze", "le douze", "le treize", "le quatorze", "le quinze", "le seize", "le dix-sept", "le dix-huit", "le dix-neuf", "vingt",
            "le vingt-et-un", "le vingt-deux", "le vingt-trois", "le vingt-quatre", "le vingt-cinq", "le vingt-six", "le vingt-sept", "le vingt-huit", "le vingt-neuf", "le trente", "le trente-et-un"};
    String[] doMDeu = {"der erste", "der zweite", "der dritte", "der vierte", "der fünfte", "der sechste", "der siebte", "der achte", "der neunte", "der zehnte",
            "der elfte", "der zwölfte", "der dreizehnte", "der vierzehnte", "der fünfzehnte", "der sechzehnte", "der siebzehnte", "der achtzehnte", "der neunzehnte", "zwanzigste",
            "der einundzwanzigste", "der zweiundzwanzigste", "der dreiundzwanzigste", "der vierundzwanzigste", "der fünfundzwanzigste", "der sechsundzwanzigste", "der siebenundzwanzigste", "der achtundzwanzigste", "der neunundzwanzigste", "der dreißigste", "der einunddreißiste"};
    String[] doMIta = {"il primo", "il due", "il tre", "il quattro", "il cinque", "il sei", "il sette", "il otto", "il nove", "il dieci",
            "il undici", "il dodoci", "il tredici", "il quattordici", "il quindici", "il sedici", "il diciassette", "il diciotto", "il diciannove", "il venti",
            "il ventuno", "il ventidue", "il ventitré", "il ventiquattro", "il venticinque", "il ventisei", "il ventisette", "il ventiotto", "il ventinove", "il trenta", "il trentuno"};
    String[] doMSpa = {"el primero", "el dos", "el tres", "el cuatro", "el cinco", "el seis", "el siete", "el ocho", "el nueve", "el diez",
            "el once", "el doce", "el trece", "el catorce", "el quince", "el dieciséis", "el diecisiete", "el dieciocho", "el diecinueve", "el veinte",
            "el veintiuno", "el veintidós", "el veintitres", "el veinticuatro", "el veinticinco", "el veintiséis", "el veintisiete", "el veintiocho", "el veintinueve", "el treinta", "el treinta y uno"};
    String[] doMRus = {"первое", "второе", "третье", "четвёртое", "пятое", "шестое", "седьмое", "восьмое", "девятое", "десятое",
            "одиннадцатое", "двенадцатое", "тринадцатое", "четырнадцатое", "пятнадцатое", "шестнадцатое", "семнадцатое", "восемнадцатое", "девятнадцатое", "двадцатое",
            "двадцать первое", "двадцать второе", "двадцать третье", "двадцать четвёртое", "двадцать пятое", "двадцать шестое", "двадцать седьмое", "двадцать восьмое", "двадцать девятое", "тридцатое", "тридцать первое"};

    String[] doWKor = {"일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"};
    String[] doWEng = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    String[] doWFra = {"dimanche", "lundi", "mardi", "mercredi", "jeudi", "vendredi", "samedi"};
    String[] doWDeu = {"Sonntag", "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag"};
    String[] doWIta = {"domenica", "lunedì", "martedì", "mercoledì", "giovedì", "venerdì", "sabato"};
    String[] doWSpa = {"domingo", "lunes", "martes", "miércoles", "jueves", "viernes", "sábado"};
    String[] doWRus = {"воскресенье", "понедельник", "вторник", "среда", "четверг", "пятница", "суббота"};

    TextView tvTitle1, tvTitle2;
    TextView tvMonthTitle, tvMonthEng, tvMonthFra, tvMonthDeu, tvMonthIta, tvMonthSpa, tvMonthRus;
    TextView tvDoMTitle, tvDoMEng, tvDoMFra, tvDoMDeu, tvDoMIta, tvDoMSpa, tvDoMRus;
    TextView tvDoWTitle, tvDoWEng, tvDoWFra, tvDoWDeu, tvDoWIta, tvDoWSpa, tvDoWRus;

    int m = 0, dM = 0, dW = 0;

    Animation aniTitle1, aniTitle2;
    Animation aniMonthEng, aniMonthFra, aniMonthDeu, aniMonthIta, aniMonthSpa, aniMonthRus;
    Animation aniDoMEng, aniDoMFra, aniDoMDeu, aniDoMIta, aniDoMSpa, aniDoMRus;
    Animation aniDoWEng, aniDoWFra, aniDoWDeu, aniDoWIta, aniDoWSpa, aniDoWRus;

    // Sidebar
    private DrawerLayout drawerLayout;
    private View drawerView;
    TextView tvNickname, tvEmail;
    ImageView btnClose;

    // Footer
    ImageButton btnSidebar, btnHome, btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        // Data from SQLite
        Intent getData = getIntent();
        strNick = getData.getStringExtra("nick");
        strPw = getData.getStringExtra("pw");
        strName = getData.getStringExtra("name");
        strEmail = getData.getStringExtra("email");
        strAvatar = getData.getStringExtra("avatar");

        // Title
        tvTitle1 = (TextView) findViewById(R.id.tvTitle1);
        tvTitle2 = (TextView) findViewById(R.id.tvTitle2);
        aniTitle1 = AnimationUtils.loadAnimation(DateActivity.this, R.anim.descend);
        aniTitle2 = AnimationUtils.loadAnimation(DateActivity.this, R.anim.descend);
        aniTitle2.setStartOffset(400);
        tvTitle1.startAnimation(aniTitle1);
        tvTitle2.startAnimation(aniTitle2);

        // Date
        tvMonthTitle = (TextView) findViewById(R.id.tvMonthTitle);
        tvMonthEng = (TextView) findViewById(R.id.tvMonthEng);
        tvMonthFra = (TextView) findViewById(R.id.tvMonthFra);
        tvMonthDeu = (TextView) findViewById(R.id.tvMonthDeu);
        tvMonthIta = (TextView) findViewById(R.id.tvMonthIta);
        tvMonthSpa = (TextView) findViewById(R.id.tvMonthSpa);
        tvMonthRus = (TextView) findViewById(R.id.tvMonthRus);
        tvDoMTitle = (TextView) findViewById(R.id.tvDoMTitle);
        tvDoMEng = (TextView) findViewById(R.id.tvDoMEng);
        tvDoMFra = (TextView) findViewById(R.id.tvDoMFra);
        tvDoMDeu = (TextView) findViewById(R.id.tvDoMDeu);
        tvDoMIta = (TextView) findViewById(R.id.tvDoMIta);
        tvDoMSpa = (TextView) findViewById(R.id.tvDoMSpa);
        tvDoMRus = (TextView) findViewById(R.id.tvDoMRus);
        tvDoWTitle = (TextView) findViewById(R.id.tvDoWTitle);
        tvDoWEng = (TextView) findViewById(R.id.tvDoWEng);
        tvDoWFra = (TextView) findViewById(R.id.tvDoWFra);
        tvDoWDeu = (TextView) findViewById(R.id.tvDoWDeu);
        tvDoWIta = (TextView) findViewById(R.id.tvDoWIta);
        tvDoWSpa = (TextView) findViewById(R.id.tvDoWSpa);
        tvDoWRus = (TextView) findViewById(R.id.tvDoWRus);

        // Setting the date
        Calendar cal = Calendar.getInstance();
        m = cal.get(Calendar.MONTH);
        dM = cal.get(Calendar.DAY_OF_MONTH);
        dW = cal.get(Calendar.DAY_OF_WEEK);

        switch (m) {
            case 0:
                tvMonthTitle.setText(monthKor[0]);
                tvMonthEng.setText(monthEng[0]);
                tvMonthFra.setText(monthFra[0]);
                tvMonthDeu.setText(monthDeu[0]);
                tvMonthIta.setText(monthIta[0]);
                tvMonthSpa.setText(monthSpa[0]);
                tvMonthRus.setText(monthRus[0]);
                break;
            case 1:
                tvMonthTitle.setText(monthKor[1]);
                tvMonthEng.setText(monthEng[1]);
                tvMonthFra.setText(monthFra[1]);
                tvMonthDeu.setText(monthDeu[1]);
                tvMonthIta.setText(monthIta[1]);
                tvMonthSpa.setText(monthSpa[1]);
                tvMonthRus.setText(monthRus[1]);
                break;
            case 2:
                tvMonthTitle.setText(monthKor[2]);
                tvMonthEng.setText(monthEng[2]);
                tvMonthFra.setText(monthFra[2]);
                tvMonthDeu.setText(monthDeu[2]);
                tvMonthIta.setText(monthIta[2]);
                tvMonthSpa.setText(monthSpa[2]);
                tvMonthRus.setText(monthRus[2]);
                break;
            case 3:
                tvMonthTitle.setText(monthKor[3]);
                tvMonthEng.setText(monthEng[3]);
                tvMonthFra.setText(monthFra[3]);
                tvMonthDeu.setText(monthDeu[3]);
                tvMonthIta.setText(monthIta[3]);
                tvMonthSpa.setText(monthSpa[3]);
                tvMonthRus.setText(monthRus[3]);
                break;
            case 4:
                tvMonthTitle.setText(monthKor[4]);
                tvMonthEng.setText(monthEng[4]);
                tvMonthFra.setText(monthFra[4]);
                tvMonthDeu.setText(monthDeu[4]);
                tvMonthIta.setText(monthIta[4]);
                tvMonthSpa.setText(monthSpa[4]);
                tvMonthRus.setText(monthRus[4]);
                break;
            case 5:
                tvMonthTitle.setText(monthKor[5]);
                tvMonthEng.setText(monthEng[5]);
                tvMonthFra.setText(monthFra[5]);
                tvMonthDeu.setText(monthDeu[5]);
                tvMonthIta.setText(monthIta[5]);
                tvMonthSpa.setText(monthSpa[5]);
                tvMonthRus.setText(monthRus[5]);
                break;
            case 6:
                tvMonthTitle.setText(monthKor[6]);
                tvMonthEng.setText(monthEng[6]);
                tvMonthFra.setText(monthFra[6]);
                tvMonthDeu.setText(monthDeu[6]);
                tvMonthIta.setText(monthIta[6]);
                tvMonthSpa.setText(monthSpa[6]);
                tvMonthRus.setText(monthRus[6]);
                break;
            case 7:
                tvMonthTitle.setText(monthKor[7]);
                tvMonthEng.setText(monthEng[7]);
                tvMonthFra.setText(monthFra[7]);
                tvMonthDeu.setText(monthDeu[7]);
                tvMonthIta.setText(monthIta[7]);
                tvMonthSpa.setText(monthSpa[7]);
                tvMonthRus.setText(monthRus[7]);
                break;
            case 8:
                tvMonthTitle.setText(monthKor[8]);
                tvMonthEng.setText(monthEng[8]);
                tvMonthFra.setText(monthFra[8]);
                tvMonthDeu.setText(monthDeu[8]);
                tvMonthIta.setText(monthIta[8]);
                tvMonthSpa.setText(monthSpa[8]);
                tvMonthRus.setText(monthRus[8]);
                break;
            case 9:
                tvMonthTitle.setText(monthKor[9]);
                tvMonthEng.setText(monthEng[9]);
                tvMonthFra.setText(monthFra[9]);
                tvMonthDeu.setText(monthDeu[9]);
                tvMonthIta.setText(monthIta[9]);
                tvMonthSpa.setText(monthSpa[9]);
                tvMonthRus.setText(monthRus[9]);
                break;
            case 10:
                tvMonthTitle.setText(monthKor[10]);
                tvMonthEng.setText(monthEng[10]);
                tvMonthFra.setText(monthFra[10]);
                tvMonthDeu.setText(monthDeu[10]);
                tvMonthIta.setText(monthIta[10]);
                tvMonthSpa.setText(monthSpa[10]);
                tvMonthRus.setText(monthRus[10]);
                break;
            case 11:
                tvMonthTitle.setText(monthKor[11]);
                tvMonthEng.setText(monthEng[11]);
                tvMonthFra.setText(monthFra[11]);
                tvMonthDeu.setText(monthDeu[11]);
                tvMonthIta.setText(monthIta[11]);
                tvMonthSpa.setText(monthSpa[11]);
                tvMonthRus.setText(monthRus[11]);
                break;
            case 12:
                tvMonthTitle.setText(monthKor[12]);
                tvMonthEng.setText(monthEng[12]);
                tvMonthFra.setText(monthFra[12]);
                tvMonthDeu.setText(monthDeu[12]);
                tvMonthIta.setText(monthIta[12]);
                tvMonthSpa.setText(monthSpa[12]);
                tvMonthRus.setText(monthRus[12]);
                break;
        }

        switch (dM) {
            case 1:
                tvDoMTitle.setText(doMKor[0]);
                tvDoMEng.setText(doMEng[0]);
                tvDoMFra.setText(doMFra[0]);
                tvDoMDeu.setText(doMDeu[0]);
                tvDoMIta.setText(doMIta[0]);
                tvDoMSpa.setText(doMSpa[0]);
                tvDoMRus.setText(doMRus[0]);
                break;
            case 2:
                tvDoMTitle.setText(doMKor[1]);
                tvDoMEng.setText(doMEng[1]);
                tvDoMFra.setText(doMFra[1]);
                tvDoMDeu.setText(doMDeu[1]);
                tvDoMIta.setText(doMIta[1]);
                tvDoMSpa.setText(doMSpa[1]);
                tvDoMRus.setText(doMRus[1]);
                break;
            case 3:
                tvDoMTitle.setText(doMKor[2]);
                tvDoMEng.setText(doMEng[2]);
                tvDoMFra.setText(doMFra[2]);
                tvDoMDeu.setText(doMDeu[2]);
                tvDoMIta.setText(doMIta[2]);
                tvDoMSpa.setText(doMSpa[2]);
                tvDoMRus.setText(doMRus[2]);
                break;
            case 4:
                tvDoMTitle.setText(doMKor[3]);
                tvDoMEng.setText(doMEng[3]);
                tvDoMFra.setText(doMFra[3]);
                tvDoMDeu.setText(doMDeu[3]);
                tvDoMIta.setText(doMIta[3]);
                tvDoMSpa.setText(doMSpa[3]);
                tvDoMRus.setText(doMRus[3]);
                break;
            case 5:
                tvDoMTitle.setText(doMKor[4]);
                tvDoMEng.setText(doMEng[4]);
                tvDoMFra.setText(doMFra[4]);
                tvDoMDeu.setText(doMDeu[4]);
                tvDoMIta.setText(doMIta[4]);
                tvDoMSpa.setText(doMSpa[4]);
                tvDoMRus.setText(doMRus[4]);
                break;
            case 6:
                tvDoMTitle.setText(doMKor[5]);
                tvDoMEng.setText(doMEng[5]);
                tvDoMFra.setText(doMFra[5]);
                tvDoMDeu.setText(doMDeu[5]);
                tvDoMIta.setText(doMIta[5]);
                tvDoMSpa.setText(doMSpa[5]);
                tvDoMRus.setText(doMRus[5]);
                break;
            case 7:
                tvDoMTitle.setText(doMKor[6]);
                tvDoMEng.setText(doMEng[6]);
                tvDoMFra.setText(doMFra[6]);
                tvDoMDeu.setText(doMDeu[6]);
                tvDoMIta.setText(doMIta[6]);
                tvDoMSpa.setText(doMSpa[6]);
                tvDoMRus.setText(doMRus[6]);
                break;
            case 8:
                tvDoMTitle.setText(doMKor[7]);
                tvDoMEng.setText(doMEng[7]);
                tvDoMFra.setText(doMFra[7]);
                tvDoMDeu.setText(doMDeu[7]);
                tvDoMIta.setText(doMIta[7]);
                tvDoMSpa.setText(doMSpa[7]);
                tvDoMRus.setText(doMRus[7]);
                break;
            case 9:
                tvDoMTitle.setText(doMKor[8]);
                tvDoMEng.setText(doMEng[8]);
                tvDoMFra.setText(doMFra[8]);
                tvDoMDeu.setText(doMDeu[8]);
                tvDoMIta.setText(doMIta[8]);
                tvDoMSpa.setText(doMSpa[8]);
                tvDoMRus.setText(doMRus[8]);
                break;
            case 10:
                tvDoMTitle.setText(doMKor[9]);
                tvDoMEng.setText(doMEng[9]);
                tvDoMFra.setText(doMFra[9]);
                tvDoMDeu.setText(doMDeu[9]);
                tvDoMIta.setText(doMIta[9]);
                tvDoMSpa.setText(doMSpa[9]);
                tvDoMRus.setText(doMRus[9]);
                break;
            case 11:
                tvDoMTitle.setText(doMKor[10]);
                tvDoMEng.setText(doMEng[10]);
                tvDoMFra.setText(doMFra[10]);
                tvDoMDeu.setText(doMDeu[10]);
                tvDoMIta.setText(doMIta[10]);
                tvDoMSpa.setText(doMSpa[10]);
                tvDoMRus.setText(doMRus[10]);
                break;
            case 12:
                tvDoMTitle.setText(doMKor[11]);
                tvDoMEng.setText(doMEng[11]);
                tvDoMFra.setText(doMFra[11]);
                tvDoMDeu.setText(doMDeu[11]);
                tvDoMIta.setText(doMIta[11]);
                tvDoMSpa.setText(doMSpa[11]);
                tvDoMRus.setText(doMRus[11]);
                break;
            case 13:
                tvDoMTitle.setText(doMKor[12]);
                tvDoMEng.setText(doMEng[12]);
                tvDoMFra.setText(doMFra[12]);
                tvDoMDeu.setText(doMDeu[12]);
                tvDoMIta.setText(doMIta[12]);
                tvDoMSpa.setText(doMSpa[12]);
                tvDoMRus.setText(doMRus[12]);
                break;
            case 14:
                tvDoMTitle.setText(doMKor[13]);
                tvDoMEng.setText(doMEng[13]);
                tvDoMFra.setText(doMFra[13]);
                tvDoMDeu.setText(doMDeu[13]);
                tvDoMIta.setText(doMIta[13]);
                tvDoMSpa.setText(doMSpa[13]);
                tvDoMRus.setText(doMRus[13]);
                break;
            case 15:
                tvDoMTitle.setText(doMKor[14]);
                tvDoMEng.setText(doMEng[14]);
                tvDoMFra.setText(doMFra[14]);
                tvDoMDeu.setText(doMDeu[14]);
                tvDoMIta.setText(doMIta[14]);
                tvDoMSpa.setText(doMSpa[14]);
                tvDoMRus.setText(doMRus[14]);
                break;
            case 16:
                tvDoMTitle.setText(doMKor[15]);
                tvDoMEng.setText(doMEng[15]);
                tvDoMFra.setText(doMFra[15]);
                tvDoMDeu.setText(doMDeu[15]);
                tvDoMIta.setText(doMIta[15]);
                tvDoMSpa.setText(doMSpa[15]);
                tvDoMRus.setText(doMRus[15]);
                break;
            case 17:
                tvDoMTitle.setText(doMKor[16]);
                tvDoMEng.setText(doMEng[16]);
                tvDoMFra.setText(doMFra[16]);
                tvDoMDeu.setText(doMDeu[16]);
                tvDoMIta.setText(doMIta[16]);
                tvDoMSpa.setText(doMSpa[16]);
                tvDoMRus.setText(doMRus[16]);
                break;
            case 18:
                tvDoMTitle.setText(doMKor[17]);
                tvDoMEng.setText(doMEng[17]);
                tvDoMFra.setText(doMFra[17]);
                tvDoMDeu.setText(doMDeu[17]);
                tvDoMIta.setText(doMIta[17]);
                tvDoMSpa.setText(doMSpa[17]);
                tvDoMRus.setText(doMRus[17]);
                break;
            case 19:
                tvDoMTitle.setText(doMKor[18]);
                tvDoMEng.setText(doMEng[18]);
                tvDoMFra.setText(doMFra[18]);
                tvDoMDeu.setText(doMDeu[18]);
                tvDoMIta.setText(doMIta[18]);
                tvDoMSpa.setText(doMSpa[18]);
                tvDoMRus.setText(doMRus[18]);
                break;
            case 20:
                tvDoMTitle.setText(doMKor[19]);
                tvDoMEng.setText(doMEng[19]);
                tvDoMFra.setText(doMFra[19]);
                tvDoMDeu.setText(doMDeu[19]);
                tvDoMIta.setText(doMIta[19]);
                tvDoMSpa.setText(doMSpa[19]);
                tvDoMRus.setText(doMRus[19]);
                break;
            case 21:
                tvDoMTitle.setText(doMKor[20]);
                tvDoMEng.setText(doMEng[20]);
                tvDoMFra.setText(doMFra[20]);
                tvDoMDeu.setText(doMDeu[20]);
                tvDoMIta.setText(doMIta[20]);
                tvDoMSpa.setText(doMSpa[20]);
                tvDoMRus.setText(doMRus[20]);
                break;
            case 22:
                tvDoMTitle.setText(doMKor[21]);
                tvDoMEng.setText(doMEng[21]);
                tvDoMFra.setText(doMFra[21]);
                tvDoMDeu.setText(doMDeu[21]);
                tvDoMIta.setText(doMIta[21]);
                tvDoMSpa.setText(doMSpa[21]);
                tvDoMRus.setText(doMRus[21]);
                break;
            case 23:
                tvDoMTitle.setText(doMKor[22]);
                tvDoMEng.setText(doMEng[22]);
                tvDoMFra.setText(doMFra[22]);
                tvDoMDeu.setText(doMDeu[22]);
                tvDoMIta.setText(doMIta[22]);
                tvDoMSpa.setText(doMSpa[22]);
                tvDoMRus.setText(doMRus[22]);
                break;
            case 24:
                tvDoMTitle.setText(doMKor[23]);
                tvDoMEng.setText(doMEng[23]);
                tvDoMFra.setText(doMFra[23]);
                tvDoMDeu.setText(doMDeu[23]);
                tvDoMIta.setText(doMIta[23]);
                tvDoMSpa.setText(doMSpa[23]);
                tvDoMRus.setText(doMRus[23]);
                break;
            case 25:
                tvDoMTitle.setText(doMKor[24]);
                tvDoMEng.setText(doMEng[24]);
                tvDoMFra.setText(doMFra[24]);
                tvDoMDeu.setText(doMDeu[24]);
                tvDoMIta.setText(doMIta[24]);
                tvDoMSpa.setText(doMSpa[24]);
                tvDoMRus.setText(doMRus[24]);
                break;
            case 26:
                tvDoMTitle.setText(doMKor[25]);
                tvDoMEng.setText(doMEng[25]);
                tvDoMFra.setText(doMFra[25]);
                tvDoMDeu.setText(doMDeu[25]);
                tvDoMIta.setText(doMIta[25]);
                tvDoMSpa.setText(doMSpa[25]);
                tvDoMRus.setText(doMRus[25]);
                break;
            case 27:
                tvDoMTitle.setText(doMKor[26]);
                tvDoMEng.setText(doMEng[26]);
                tvDoMFra.setText(doMFra[26]);
                tvDoMDeu.setText(doMDeu[26]);
                tvDoMIta.setText(doMIta[26]);
                tvDoMSpa.setText(doMSpa[26]);
                tvDoMRus.setText(doMRus[26]);
                break;
            case 28:
                tvDoMTitle.setText(doMKor[27]);
                tvDoMEng.setText(doMEng[27]);
                tvDoMFra.setText(doMFra[27]);
                tvDoMDeu.setText(doMDeu[27]);
                tvDoMIta.setText(doMIta[27]);
                tvDoMSpa.setText(doMSpa[27]);
                tvDoMRus.setText(doMRus[27]);
                break;
            case 29:
                tvDoMTitle.setText(doMKor[28]);
                tvDoMEng.setText(doMEng[28]);
                tvDoMFra.setText(doMFra[28]);
                tvDoMDeu.setText(doMDeu[28]);
                tvDoMIta.setText(doMIta[28]);
                tvDoMSpa.setText(doMSpa[28]);
                tvDoMRus.setText(doMRus[28]);
                break;
            case 30:
                tvDoMTitle.setText(doMKor[29]);
                tvDoMEng.setText(doMEng[29]);
                tvDoMFra.setText(doMFra[29]);
                tvDoMDeu.setText(doMDeu[29]);
                tvDoMIta.setText(doMIta[29]);
                tvDoMSpa.setText(doMSpa[29]);
                tvDoMRus.setText(doMRus[29]);
                break;
            case 31:
                tvDoMTitle.setText(doMKor[30]);
                tvDoMEng.setText(doMEng[30]);
                tvDoMFra.setText(doMFra[30]);
                tvDoMDeu.setText(doMDeu[30]);
                tvDoMIta.setText(doMIta[30]);
                tvDoMSpa.setText(doMSpa[30]);
                tvDoMRus.setText(doMRus[30]);
                break;
        }

        switch (dW) {
            case 1:
                tvDoWTitle.setText(doWKor[0]);
                tvDoWEng.setText(doWEng[0]);
                tvDoWFra.setText(doWFra[0]);
                tvDoWDeu.setText(doWDeu[0]);
                tvDoWIta.setText(doWIta[0]);
                tvDoWSpa.setText(doWSpa[0]);
                tvDoWRus.setText(doWRus[0]);
                break;
            case 2:
                tvDoWTitle.setText(doWKor[1]);
                tvDoWEng.setText(doWEng[1]);
                tvDoWFra.setText(doWFra[1]);
                tvDoWDeu.setText(doWDeu[1]);
                tvDoWIta.setText(doWIta[1]);
                tvDoWSpa.setText(doWSpa[1]);
                tvDoWRus.setText(doWRus[1]);
                break;
            case 3:
                tvDoWTitle.setText(doWKor[2]);
                tvDoWEng.setText(doWEng[2]);
                tvDoWFra.setText(doWFra[2]);
                tvDoWDeu.setText(doWDeu[2]);
                tvDoWIta.setText(doWIta[2]);
                tvDoWSpa.setText(doWSpa[2]);
                tvDoWRus.setText(doWRus[2]);
                break;
            case 4:
                tvDoWTitle.setText(doWKor[3]);
                tvDoWEng.setText(doWEng[3]);
                tvDoWFra.setText(doWFra[3]);
                tvDoWDeu.setText(doWDeu[3]);
                tvDoWIta.setText(doWIta[3]);
                tvDoWSpa.setText(doWSpa[3]);
                tvDoWRus.setText(doWRus[3]);
                break;
            case 5:
                tvDoWTitle.setText(doWKor[4]);
                tvDoWEng.setText(doWEng[4]);
                tvDoWFra.setText(doWFra[4]);
                tvDoWDeu.setText(doWDeu[4]);
                tvDoWIta.setText(doWIta[4]);
                tvDoWSpa.setText(doWSpa[4]);
                tvDoWRus.setText(doWRus[4]);
                break;
            case 6:
                tvDoWTitle.setText(doWKor[5]);
                tvDoWEng.setText(doWEng[5]);
                tvDoWFra.setText(doWFra[5]);
                tvDoWDeu.setText(doWDeu[5]);
                tvDoWIta.setText(doWIta[5]);
                tvDoWSpa.setText(doWSpa[5]);
                tvDoWRus.setText(doWRus[5]);
                break;
            case 7:
                tvDoWTitle.setText(doWKor[6]);
                tvDoWEng.setText(doWEng[6]);
                tvDoWFra.setText(doWFra[6]);
                tvDoWDeu.setText(doWDeu[6]);
                tvDoWIta.setText(doWIta[6]);
                tvDoWSpa.setText(doWSpa[6]);
                tvDoWRus.setText(doWRus[6]);
                break;
        }

        // Sidebar
        tvNickname = (TextView) findViewById(R.id.tvNickname);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerView = (View) findViewById(R.id.drawer);
        drawerLayout.setDrawerListener(drawerListener);
        drawerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        btnClose = (ImageView) findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();
            }
        });

        // Title (Animation)
        tvMonthTitle = (TextView) findViewById(R.id.tvMonthTitle);
        tvDoMTitle = (TextView) findViewById(R.id.tvDoMTitle);
        tvDoWTitle = (TextView) findViewById(R.id.tvDoWTitle);
        aniTitle1 = AnimationUtils.loadAnimation(DateActivity.this, R.anim.descend);
        aniTitle2 = AnimationUtils.loadAnimation(DateActivity.this, R.anim.descend);
        aniTitle2.setStartOffset(400);
        tvTitle1.startAnimation(aniTitle1);
        tvTitle2.startAnimation(aniTitle2);

        // Date : Month (Animation)
        aniMonthEng = AnimationUtils.loadAnimation(DateActivity.this, R.anim.ascend_fast);
        aniMonthEng.setStartOffset(400);
        aniMonthFra = AnimationUtils.loadAnimation(DateActivity.this, R.anim.ascend_fast);
        aniMonthFra.setStartOffset(600);
        aniMonthDeu = AnimationUtils.loadAnimation(DateActivity.this, R.anim.ascend_fast);
        aniMonthDeu.setStartOffset(800);
        aniMonthIta = AnimationUtils.loadAnimation(DateActivity.this, R.anim.ascend_fast);
        aniMonthIta.setStartOffset(1000);
        aniMonthSpa = AnimationUtils.loadAnimation(DateActivity.this, R.anim.ascend_fast);
        aniMonthSpa.setStartOffset(1200);
        aniMonthRus = AnimationUtils.loadAnimation(DateActivity.this, R.anim.ascend_fast);
        aniMonthRus.setStartOffset(1400);
        tvMonthEng.startAnimation(aniMonthEng);
        tvMonthFra.startAnimation(aniMonthFra);
        tvMonthDeu.startAnimation(aniMonthDeu);
        tvMonthIta.startAnimation(aniMonthIta);
        tvMonthSpa.startAnimation(aniMonthSpa);
        tvMonthRus.startAnimation(aniMonthRus);

        // Date : Day of the Month (Animation)
        aniDoMEng = AnimationUtils.loadAnimation(DateActivity.this, R.anim.ascend_fast);
        aniDoMEng.setStartOffset(500);
        aniDoMFra = AnimationUtils.loadAnimation(DateActivity.this, R.anim.ascend_fast);
        aniDoMFra.setStartOffset(700);
        aniDoMDeu = AnimationUtils.loadAnimation(DateActivity.this, R.anim.ascend_fast);
        aniDoMDeu.setStartOffset(900);
        aniDoMIta = AnimationUtils.loadAnimation(DateActivity.this, R.anim.ascend_fast);
        aniDoMIta.setStartOffset(1100);
        aniDoMSpa = AnimationUtils.loadAnimation(DateActivity.this, R.anim.ascend_fast);
        aniDoMSpa.setStartOffset(1300);
        aniDoMRus = AnimationUtils.loadAnimation(DateActivity.this, R.anim.ascend_fast);
        aniDoMRus.setStartOffset(1500);
        tvDoMEng.startAnimation(aniDoMEng);
        tvDoMFra.startAnimation(aniDoMFra);
        tvDoMDeu.startAnimation(aniDoMDeu);
        tvDoMIta.startAnimation(aniDoMIta);
        tvDoMSpa.startAnimation(aniDoMSpa);
        tvDoMRus.startAnimation(aniDoMRus);

        // Date : Day of the Week (Animation)
        aniDoWEng = AnimationUtils.loadAnimation(DateActivity.this, R.anim.ascend_fast);
        aniDoWEng.setStartOffset(600);
        aniDoWFra = AnimationUtils.loadAnimation(DateActivity.this, R.anim.ascend_fast);
        aniDoWFra.setStartOffset(800);
        aniDoWDeu = AnimationUtils.loadAnimation(DateActivity.this, R.anim.ascend_fast);
        aniDoWDeu.setStartOffset(1000);
        aniDoWIta = AnimationUtils.loadAnimation(DateActivity.this, R.anim.ascend_fast);
        aniDoWIta.setStartOffset(1200);
        aniDoWSpa = AnimationUtils.loadAnimation(DateActivity.this, R.anim.ascend_fast);
        aniDoWSpa.setStartOffset(1400);
        aniDoWRus = AnimationUtils.loadAnimation(DateActivity.this, R.anim.ascend_fast);
        aniDoWRus.setStartOffset(1600);
        tvDoWEng.startAnimation(aniDoWEng);
        tvDoWFra.startAnimation(aniDoWFra);
        tvDoWDeu.startAnimation(aniDoWDeu);
        tvDoWIta.startAnimation(aniDoWIta);
        tvDoWSpa.startAnimation(aniDoWSpa);
        tvDoWRus.startAnimation(aniDoWRus);

        // Footer
        btnSidebar = (ImageButton) findViewById(R.id.btnSidebar);
        btnHome = (ImageButton) findViewById(R.id.btnHome);
        btnUpdate = (ImageButton) findViewById(R.id.btnUpdate);
        btnSidebar.setOnClickListener(mClickListener);
        btnHome.setOnClickListener(mClickListener);
        btnUpdate.setOnClickListener(mClickListener);
    }

    // Back Button
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intentBack = new Intent(DateActivity.this, MainActivity.class);
        intentBack.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intentBack.putExtra("nick", strNick);
        intentBack.putExtra("pw", strPw);
        intentBack.putExtra("name", strName);
        intentBack.putExtra("email", strEmail);
        intentBack.putExtra("avatar", strAvatar);
        startActivity(intentBack);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        finish();
    }

    // Sidebar
    DrawerLayout.DrawerListener drawerListener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {
            if (strNick == null) {
                tvNickname.setText("제이슨");
            } else {
                tvNickname.setText(strNick);
            }
            if (strEmail == null) {
                tvEmail.setText("luxionary@gmail.com");
            } else {
                tvEmail.setText(strEmail);
            }
        }

        @Override
        public void onDrawerClosed(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnSidebar:
                    drawerLayout.openDrawer(drawerView);
                    break;
                case R.id.btnHome:
                    Intent intentHome = new Intent(DateActivity.this, MainActivity.class);
                    startActivity(intentHome);
                    intentHome.putExtra("nick", strNick);
                    intentHome.putExtra("pw", strPw);
                    intentHome.putExtra("name", strName);
                    intentHome.putExtra("email", strEmail);
                    intentHome.putExtra("avatar", strAvatar);
                    overridePendingTransition(R.anim.fadein, R.anim.fadeout); // 화면 전환 애니메이션
                    finish();
                    break;
                case R.id.btnUpdate:
                    break;
            }
        }
    };
}

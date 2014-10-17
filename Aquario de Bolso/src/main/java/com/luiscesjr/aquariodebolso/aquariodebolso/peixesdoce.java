package com.luiscesjr.aquariodebolso.aquariodebolso;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.luiscesjr.aquariodebolso.aquariodebolso.peixesdoce_layouts.CalvusBlack;

public class peixesdoce extends Activity {

    // List view
    private ListView lv;

    // Listview Adapter
    ArrayAdapter<String> adapter;

    // Search EditText
    EditText inputSearch;


    // ArrayList for Listview
    ArrayList<HashMap<String, String>> productList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peixesdoce);

        // Listview Data
        String products[] = {"Calvus Black", "Gold Kasanga", "Flowerhorn", "Tetra Paraguaio", "Aphyosemion australe",
                "Aphyosemion cognatum", "Aphyosemion striatum",
                "Apisto agassizi", "Apisto boreli", "Apisto cacatuoides", "Apisto panduro", "Apisto trifasciata",
                "Astatotilapia","Oscar","Tetra cego das cavernas","Freibergi","Nyassae","Stuartgranti, Ngara",
                "Austrolebias nigripinnis","Tricoti","Betta","Bótia Yoyo","Macrops","Pleurospilus","Kinguio",
                "Peixe Borboleta","Cabeça-de-Serpente Arco-Íris","Channa Anã","Mocinha","Chromaphyosemion bitaeniatum","Bótia palhaço","Baiacu Amazônico",
                "Corydora Anã","Corydora Julii","Corydora Pimenta","Corydora Schwartzi","Corydora Albina","Corydora Sterbai","Xadrezinho",
                "Foae","Cynotilapia Lumbila","Cynotilapia Cobwe","Cynotilapia Hara","Frontosa","Frontosa gibberosa","Leptosoma Mpulungu",
                "Cyrtocara moorii","Rasbora Galaxy","Paulistinha","Badis Vermelho","Dianema Zebra","Descampsii","Labeo Frenatus",
                "Annulatus","Epiplatys Dageti","Peixe-Corda","Fundulopanchax spoorembergi","Cará","Tetra Negro","Peixe Jóia","Tetra Glowlight","Rodóstomus",
                "Cruzeiro do sul","Papagaio Verdadeiro","Cascudo Zebra","Tetra Foguinho","Tetra Amarelo","Matogrosso","Rosáceo","Tetra Engraçadinho","Neon Negro","Tetra Limão","Tetra Fantasma Vermelho",
                "Sprengerae","Juli dickfeldi","Marlieri","Juli Regani","Juli transcriptus","Trewavasae Red Top","Eletric Yellow","Labidochromis White","Mbamba","Ocellatus gold","Lamprologus Ornatipinnis",
                "Leptolebias aureoguttatus","Peixe Paraíso","Callainos","Greshakei","Auratus","Maigano","Joanjohnsonae","Arco-Iris Neon","Acará festivo","Red Zebra","Alstipinosa / Papilocromis",
                "Ramirezi","Tetra Imperador","Boulengeri","Brevis","Brichardi","Buescheri","Caudopunctatus","Kungweensis","Leleupi","Multifasciatus","Mustax",
                "Signatus","Similis","Five bar","Freibergi","Nothobranchius foerschi","Notho guentheri 'zanzibar'","Ventralis","Gourami Gigante","Limpa-Vidros","Neon cardinal","Neon Verdadeiro",
                "Neon Verde","Brieni, Velifer","Nigripinis","Gourami Anis","Oto Cauda-Vermelha","Kribensis","Tetra Congo","Molinésia Latipina","Guppy / Lebiste","Molinésia Shenops","Bichir Tigre / Endli",
                "Bichir Marmorato","Bichir do senegal","Arraia Leopoldi","Arraia Motoro","Tetra Pristela","Steveni Taiwan","Protomelas spilonotus","Acei Msuli","Crabro","Pombo","Flavus",
                "Lombardoi","Saulosi","Socolofi","Acará Bandeira Altum","Acará Bandeira","Barbo Arulius","Barbo Denisoni","Barbo Xadrez","Barbo Ouro","Barbo Sumatra","Barbo Titeia / Barbo Cereja",
                "Caliurus","Fryeri","Acará Disco","Peixe-Gato Invertido","Temporalis","T. vittatus","Colisa Mel","Colisa Labiosa","Colisa Lalia","Colisa Cobalto","Tricogaster Leri",
                "Trichogaster Amarelo / Azul","Otostigma","Tropheus brichardi","Tropheus duboisi","Tropheus moorii","Black Bemba","Tropheus Kiriza","Red Moliro","Lamprologus moori","Peixe-Faca Africano","Flavipinnis",
                "Ornatipinnis","Espada",};

        lv = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.inputSearch);

        // Adding items to listview
        adapter = new ArrayAdapter<String>(this, R.layout.peixeslist, R.id.product_name, products);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView parent, View view,int position, long _id) {
                String values = adapter.getItem(position);

// TODO Auto-generated method stub
                Intent i =null;

                if (values=="Calvus Black") {
                    i=new Intent(peixesdoce.this, CalvusBlack.class);
                    startActivity(i);}
                if (values=="Gold Kasanga") {
                    i=new Intent(peixesdoce.this, infomenu.class);
                    startActivity(i);}
                if (values=="Flowerhorn") {
                    i=new Intent(peixesdoce.this, infomenu.class);
                    startActivity(i);}
                if (values=="Tetra Paraguaio") {
                    i=new Intent(peixesdoce.this, infomenu.class);
                    startActivity(i);
                }

            }
        });

        /**
         * Enabling Search Filter
         * */
        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                peixesdoce.this.adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });
    }
}
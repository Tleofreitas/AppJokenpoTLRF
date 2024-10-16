package com.example.appjokenpotlrf;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void selecionarPedra(View view) {
        verificarGanhador("Pedra");
    }

    public void selecionarPapel(View view) {
        verificarGanhador("Papel");
    }

    public void selecionarTesoura(View view) {
        verificarGanhador("Tesoura");
    }

    private String gerarEscolhaDoApp() {
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        int numeroAleatorio = new Random().nextInt(3);

        ImageView imagemApp = findViewById(R.id.image_app);

        String escolhaDoApp = opcoes[numeroAleatorio];

        switch (escolhaDoApp) {
            case "Pedra" :
                imagemApp.setImageResource(R.drawable.pedra);
                break;
            case "Papel" :
                imagemApp.setImageResource(R.drawable.papel);
                break;
            case "Tesoura" :
                imagemApp.setImageResource(R.drawable.tesoura);
                break;
        }

        return escolhaDoApp;
    }

    private void verificarGanhador(String escolhaDoUsuario) {
        String escolhaDoApp = gerarEscolhaDoApp();

        TextView textoResultado = findViewById(R.id.text_resultado);

        if((escolhaDoApp=="Pedra" && escolhaDoUsuario=="Tesoura") ||
           (escolhaDoApp=="Papel" && escolhaDoUsuario=="Pedra") ||
           (escolhaDoApp=="Tesoura" && escolhaDoUsuario=="Papel")
        ) {
            textoResultado.setText("Você PERDEU =/ !");

        } else if((escolhaDoUsuario=="Pedra" && escolhaDoApp=="Tesoura") ||
                (escolhaDoUsuario=="Papel" && escolhaDoApp=="Pedra") ||
                (escolhaDoUsuario=="Tesoura" && escolhaDoApp=="Papel")
        ){
            textoResultado.setText("Você GANHOU =D !");

        } else {
            textoResultado.setText("EMPATAMOS ;)");
        }
    }
}
package br.com.dio.desafio.dominio;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.ArrayList;

public class CSharpDev extends Dev{
    protected ArrayList<Conteudo> conteudosMicrosoft = new ArrayList<Conteudo>();
    protected ArrayList<Conteudo> conteudosMicrosoftConcluidos = new ArrayList<Conteudo>();

    @Override
    public void inscreverBootcamp(Bootcamp bootcamp){
        super.inscreverBootcamp(bootcamp);
        this.conteudosMicrosoft.addAll(bootcamp.getConteudos());
    }

    @Override
    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if(conteudo.isPresent()) {
            if(conteudo.get().getTitulo() == "curso csharp"){
                conteudosMicrosoft.remove(conteudo.get());
                conteudosMicrosoftConcluidos.add(conteudo.get());
            }
        }
        super.progredir();
    }
    @Override
    public double calcularTotalXp() { //Ganha 20 pontos extras por cada conteudo MS concluido
        Iterator<Conteudo> iterator = this.conteudosConcluidos.iterator();
        double soma = 0;
        while(iterator.hasNext()){
            double next = iterator.next().calcularXp();
            soma += next;
        }
        for(Conteudo conteudo : this.conteudosMicrosoftConcluidos){
            soma += 20;
        }
        return soma;
    }
}

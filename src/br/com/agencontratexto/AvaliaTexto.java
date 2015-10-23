package br.com.agencontratexto;

import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

public class AvaliaTexto extends FitnessFunction{
    
    private char[] textoDesejado;
    
    public AvaliaTexto(String texto){
        textoDesejado = texto.toCharArray();
    }
    
    @Override
    protected double evaluate(IChromosome ic) {
        
        int valorAvaliacao = 0;
        System.out.print("Cromossomo Avaiado: ");
        for(int i = 0; i < ic.size(); i++){
            
            String geneAtual = (String) ic.getGene(i).getAllele();
            System.out.print(geneAtual);
            if(geneAtual.toCharArray()[0] == textoDesejado[i])
                valorAvaliacao++;
        }
        System.out.println(" - Valor: " + valorAvaliacao);
        return valorAvaliacao;
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campeonatos;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Wesley
 */
public class Estadios {
    private int codigo;
    private String nomeEstadio;
    private String cidade;
    private String estado;
    private int capacidade;
    ArrayList<Jogos> ListaJogos;
    
    public Estadios(){
        ListaJogos = new ArrayList();
    }

    public Estadios(int codigo, String nomeEstadio, String cidade, String estado, int capacidade) {
        this.codigo = codigo;
        this.nomeEstadio = nomeEstadio;
        this.cidade = cidade;
        this.estado = estado;
        this.capacidade = capacidade;
        ListaJogos = new ArrayList();
    }
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeEstadio() {
        return nomeEstadio;
    }

    public void setNomeEstadio(String nomeEstadio) {
        this.nomeEstadio = nomeEstadio;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public ArrayList<Jogos> getListaJogos() {
        return ListaJogos;
    }

    public void setListaJogos(ArrayList<Jogos> ListaJogos) {
        this.ListaJogos = ListaJogos;
    }

    public void addjJogos(Jogos J){
        J.setEstadios(this);
        ListaJogos.add(J);
    }
    
    public static void serializar(ArrayList<Estadios> lista) throws IOException{
        XStream x = new XStream(new DomDriver());
        String arquivoXML = x.toXML(lista);
        File file = new File("Estadios.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(arquivoXML);
        bw.close();
    }
   
    public static ArrayList<Estadios> deserealiza() throws FileNotFoundException, IOException{
        FileReader ler = new FileReader("Estadios.txt");
        BufferedReader reader = new BufferedReader(ler);
        String linha= "";
        String arquivo= "";
        while((linha = reader.readLine()) != null){
            arquivo += linha + "\n";
        }
        ArrayList<Estadios> lista = new ArrayList<>();
        XStream x = new XStream(new DomDriver());
        lista = (ArrayList<Estadios>) x.fromXML(arquivo);
        return lista;
    }   
    
    
}

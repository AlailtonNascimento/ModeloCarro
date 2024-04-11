using System;
using System.Collections.Generic;

namespace diagramaClasses;

class Program
{
    public class Carro {
    public string NumeroDaPlaca { get; set; }
    public string Cor { get; set; }
    public int Ano { get; set; }
    public string TipoDeCombustivel { get; set; }
    public int NumeroDePortas { get; set; }
    public int Quilometragem { get; set; }
    public string RENAVAM { get; set; }
    public string Chassi { get; set; }
    public double ValorDeLocacao { get; set; }
    public Modelo Modelo { get; set; }
    public List<Locacao> Locacoes { get; set; }
}
public class Modelo {
    public string Nome { get; set; }
    public Marca Marca { get; set; }
    public List<Carro> Carros { get; set; }
}

public class Marca {
    public string Nome { get; set; }
    public List<Modelo> Modelos { get; set; }
}

public class Cliente {
    public string Nome { get; set; }
    public List<Locacao> Locacoes { get; set; }
}

public class Locacao {
    public DateTime DataHoraLocacao { get; set; }
    public DateTime DataHoraDevolucao { get; set; }
    public Carro Carro { get; set; }
    public Cliente Cliente { get; set; }
}
    public static void Main(String[] args)
    {

        Carro carro = new Carro
        {
            NumeroDaPlaca = "XYZ 1234",
            Cor = "Vermelho",
            Ano = 2020,
            TipoDeCombustivel = "Gasolina",
            NumeroDePortas = 4,
            Quilometragem = 15000,
            RENAVAM = "123456789",
            Chassi = "1HGCM82633A123456",
            ValorDeLocacao = 100.0,
            Modelo = new Modelo { Nome = "Model S", Marca = new Marca { Nome = "Tesla" } },
            Locacoes = new List<Locacao>()
        };

        Console.WriteLine($"Carro: {carro.Modelo.Marca.Nome} {carro.Modelo.Nome}");
        Console.WriteLine($"Número da Placa: {carro.NumeroDaPlaca}");
        Console.WriteLine($"Cor: {carro.Cor}");
        Console.WriteLine($"Ano: {carro.Ano}");
        Console.WriteLine($"Tipo de Combustível: {carro.TipoDeCombustivel}");
        Console.WriteLine($"Número de Portas: {carro.NumeroDePortas}");
        Console.WriteLine($"Quilometragem: {carro.Quilometragem}");
        Console.WriteLine($"RENAVAM: {carro.RENAVAM}");
        Console.WriteLine($"Chassi: {carro.Chassi}");
        Console.WriteLine($"Valor de Locação: {carro.ValorDeLocacao}");

    }



        
}
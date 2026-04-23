using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Alura.Adopet.Console.Modelos;

namespace Alura.Adopet.Console.Util
{
    public class PetAPartirDoCsv
    {
        public Pet ConverteDoTexto(string linha)
        {
            string[]? propriedades = linha.Split(';');

            Pet pet = new Pet(Guid.Parse(propriedades[0]), propriedades[1], int.Parse(propriedades[2]) == 1 ? TipoPet.Gato : TipoPet.Cachorro);

            return pet;
        }
    }
}

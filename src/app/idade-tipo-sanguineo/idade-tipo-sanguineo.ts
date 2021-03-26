
export class TipoIdade  {
    tipo: string = '';
    idade: string = '';

    constructor(tipo: string, idade: number) {
        this.tipo = tipo;
        this.idade = idade.toFixed(2); 
    }
}
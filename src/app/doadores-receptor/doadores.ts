
export class Doadores  {
    tipoReceptor: string = '';
    quantidade: number = 0;

    constructor(tipoReceptor: string, quantidade: number) {
        this.tipoReceptor = tipoReceptor;
        this.quantidade = quantidade; 
    }
}
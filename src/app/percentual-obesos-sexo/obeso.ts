
export class Obeso  {
    sexo: string = '';
    percentual: string = '';

    constructor(sexo: string, percentual: number) {
        this.sexo = sexo;
        this.percentual =  percentual.toFixed(2); 
    }
}
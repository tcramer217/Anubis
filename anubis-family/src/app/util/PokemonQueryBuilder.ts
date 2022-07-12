import {FormGroup} from '@angular/forms';


export default class PokemonQueryBuilder {
  public static buildPokeQuery(form: FormGroup | null): string {
    let qString = 'q=set.id:base1 ';
    if (form === null || !form.valid) {
      return 'q=set.id:base1&orderBy=name';
    }
    if (form.value.name !== '') {
      qString += 'name:' + form.value.name + '* ';
    }

    if (form.value.cardType.length > 0) {
      if (form.value.cardType.length === 1) {
        qString += 'supertype:' + form.value.cardType[0] + ' ';
      } else {
        qString += '(supertype:';
        form.value.cardType.forEach((type:any, index:number) => {
          if (index === 0) {
            qString += '' + type + ' ';
          } else {
            qString += ' OR supertype:' + type + ' ';
          }
        })
        qString += ')'
      }
    }

    qString += '&orderBy=name';
    return qString;
  }
}
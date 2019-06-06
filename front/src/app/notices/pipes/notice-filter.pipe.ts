import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'noticeFilter'
})
export class NoticeFilterPipe implements PipeTransform {

 
  transform(value: any, arg: any): any {
    if (arg === '' || arg.length < 1) return value;
    const arrayNotices = [];
    for (const notices of value) {
      if (notices.titulo.toLowerCase().indexOf(arg.toLowerCase()) > -1) {
        arrayNotices.push(notices);
      };
    };
    return arrayNotices;
  }

}

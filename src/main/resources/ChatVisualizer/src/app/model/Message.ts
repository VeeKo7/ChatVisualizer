export class Message {

  private _time: string;
  private _date: string;
  private _userName: string;
  private _text: string;

  constructor(time: string, date: string, userName: string, text: string) {
    this._time = time;
    this._date = date;
    this._userName = userName;
    this._text = text;
  }

  get time(): string {
    return this._time;
  }

  set time(value: string) {
    this._time = value;
  }

  get date(): string {
    return this._date;
  }

  set date(value: string) {
    this._date = value;
  }

  get userName(): string {
    return this._userName;
  }

  set userName(value: string) {
    this._userName = value;
  }

  get text(): string {
    return this._text;
  }

  set text(value: string) {
    this._text = value;
  }
}

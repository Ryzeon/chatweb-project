import {IEntity} from "../../shared/model/IEntity";

export class ChatGroup extends IEntity {

  name: string;

  constructor(id: number, name: string) {
    super(id);
    this.name = name;
  }
}

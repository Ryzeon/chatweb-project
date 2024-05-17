import { Injectable } from '@angular/core';
import {BaseService} from "../../../shared/service/http/BaseService";
import {ChatGroup} from "../../model/ChatGroup";

@Injectable({
  providedIn: 'root'
})
export class ChatGroupServiceService extends BaseService<ChatGroup> {

}

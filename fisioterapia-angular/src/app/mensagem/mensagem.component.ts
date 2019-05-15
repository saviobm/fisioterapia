import { Message } from '../model/message';
import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA, MatDialog } from '@angular/material';

@Component({
  selector: 'app-mensagem',
  templateUrl: './mensagem.component.html',
  styleUrls: ['./mensagem.component.css']
})
export class MensagemComponent implements OnInit {

  constructor( public dialogRef: MatDialogRef<MensagemComponent>, @Inject(MAT_DIALOG_DATA) public message: Message) { }

  ngOnInit() {
    this.dialogRef.updateSize("450px", "250px");
  }

}

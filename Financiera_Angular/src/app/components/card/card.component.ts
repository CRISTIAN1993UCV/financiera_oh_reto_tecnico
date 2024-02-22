// popup.component.ts
import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'component-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent {
  @Input() title: string = '';
  @Output() closed = new EventEmitter();

  closeCard(event: Event) {
    const target = event.target as HTMLElement;
    if (target.classList.contains('close-btn')) {
      this.closed.emit();
    }
  }
}

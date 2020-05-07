package com.kpztech.practice.hearthstone.battlefield;

import com.kpztech.practice.hearthstone.player.Player;
import lombok.Data;

@Data
public class BattleResult {
	private Player winner;
	// resultEnum : 0=tie 1=player1 wins 2=player2 wins
	private Integer result;
}

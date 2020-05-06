package com.kpztech.practice.hearthstone.player;

import com.kpztech.practice.hearthstone.minion.Minion;
import lombok.Data;

import java.util.List;

@Data
public class Player {
	private String name;
	private List<Minion> minions;
}

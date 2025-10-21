class GridWorld:
    def __init__(
        self,
        grid_size=(4, 3),
        start=(0, 2),
        terminal_positive=(3, 0),
        terminal_negative=(3, 1),
        obstacles={(1, 1)},
        discount_factor=0.9,
    ):
        # Accept (w, h) or a single int for a square world
        if isinstance(grid_size, tuple):
            self.width, self.height = map(int, grid_size)
        else:
            self.width = self.height = int(grid_size)

        self.start = start
        self.terminal_positive = terminal_positive
        self.terminal_negative = terminal_negative
        self.terminals = {terminal_positive, terminal_negative}
        self.obstacles = set(obstacles)
        self.discount_factor = float(discount_factor)

        self.states = self._create_states()

    def _create_states(self):
        states = []
        for x in range(self.width):
            for y in range(self.height):
                s = (x, y)
                if s not in self.terminals and s not in self.obstacles:
                    states.append(s)
        return states

    def get_states(self):
        return list(self.states)

    def get_actions(self, state):
        if state in self.terminals:
            return []
        actions = []
        x, y = state
        if x > 0 and (x - 1, y) not in self.obstacles:
            actions.append("left")
        if x < self.width - 1 and (x + 1, y) not in self.obstacles:
            actions.append("right")
        if y > 0 and (x, y - 1) not in self.obstacles:
            actions.append("up")
        if y < self.height - 1 and (x, y + 1) not in self.obstacles:
            actions.append("down")
        return actions

    def _transition(self, state, action):
        x, y = state
        nxt = state
        if action == "left":
            nxt = (x - 1, y)
        elif action == "right":
            nxt = (x + 1, y)
        elif action == "up":
            nxt = (x, y - 1)
        elif action == "down":
            nxt = (x, y + 1)

        # walls, borders, and obstacles act as no-op (stay in place)
        if (
            nxt[0] < 0
            or nxt[0] >= self.width
            or nxt[1] < 0
            or nxt[1] >= self.height
            or nxt in self.obstacles
        ):
            nxt = state
        return nxt

    def get_transition_probabilities(self, state, action):
        # Deterministic dynamics
        next_state = self._transition(state, action)
        return {next_state: 1.0}

    def get_reward(self, state, action, next_state):
        if next_state == self.terminal_positive:
            return 1.0
        if next_state == self.terminal_negative:
            return -1.0
        return 0.0
class QTable:
    def __init__(self, alpha=1.0):
        self.alpha = alpha
        self.q_values = {}

    def update(self, state, action, value):
        if state not in self.q_values:
            self.q_values[state] = {}
        self.q_values[state][action] = value

    def get_value(self, state, action):
        return self.q_values.get(state, {}).get(action, 0.0)

    def get_argmax_q(self, state, actions):
        if state not in self.q_values:
            return None
        return max(actions, key=lambda action: self.get_value(state, action), default=None)
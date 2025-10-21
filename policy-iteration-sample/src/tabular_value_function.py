class TabularValueFunction:
    def __init__(self):
        self.values = {}

    def get_value(self, state):
        return self.values.get(state, 0.0)

    def add(self, state, value):
        self.values[state] = value

    def get_q_value(self, mdp, state, action):
        # Assuming the MDP has a method to get the transition probabilities and rewards
        q_value = 0.0
        for next_state, prob in mdp.get_transition_probabilities(state, action).items():
            reward = mdp.get_reward(state, action, next_state)
            q_value += prob * (reward + mdp.discount_factor * self.get_value(next_state))
        return q_value
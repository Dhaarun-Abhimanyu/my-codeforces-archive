class TabularPolicy:
    def __init__(self, actions):
        self.policy = {}
        self.actions = actions

    def select_action(self, state, available_actions):
        return self.policy.get(state, available_actions[0])

    def update(self, state, action):
        self.policy[state] = action

    def get_policy(self):
        return self.policy

    def __str__(self):
        return str(self.policy)
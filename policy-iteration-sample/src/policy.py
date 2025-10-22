from .tabular_policy import TabularPolicy
from .tabular_value_function import TabularValueFunction
from .qtable import QTable


class PolicyIteration:
    def __init__(self, mdp, policy):
        self.mdp = mdp
        self.policy = policy

    def policy_evaluation(self, policy, values, theta=0.001, on_sweep=None):
        # Evaluate V(s) for current policy until convergence
        while True:
            delta = 0.0
            for state in self.mdp.get_states():
                actions = self.mdp.get_actions(state)
                old_value = values.get_value(state)
                new_value = values.get_q_value(
                    self.mdp, state, policy.select_action(state, actions)
                )
                values.add(state, new_value)
                delta = max(delta, abs(old_value - new_value))

            # optional snapshot after each sweep
            if on_sweep is not None:
                on_sweep(values.values.copy())

            if delta < theta:
                break
        return values

    """ Implmentation of policy iteration iteration. Returns the number of iterations executed """

    def policy_iteration(
        self,
        max_iterations=100,
        theta=0.001,
        on_evaluation_sweep=None,
        on_improvement=None,
    ):
        # create a value function to hold details
        values = TabularValueFunction()

        for i in range(1, max_iterations + 1):
            policy_changed = False
            values = self.policy_evaluation(self.policy, values, theta, on_sweep=on_evaluation_sweep)

            for state in self.mdp.get_states():
                actions = self.mdp.get_actions(state)
                old_action = self.policy.select_action(state, actions)

                q_values = QTable(alpha=1.0)
                for action in self.mdp.get_actions(state):
                    new_value = values.get_q_value(self.mdp, state, action)
                    q_values.update(state, action, new_value)

                new_action = q_values.get_argmax_q(state, self.mdp.get_actions(state))
                self.policy.update(state, new_action)
                policy_changed = True if new_action is not old_action else policy_changed

            # optional snapshot after each improvement
            if on_improvement is not None:
                on_improvement(self.policy.policy.copy(), values.values.copy(), i)

            if not policy_changed:
                return i

        return max_iterations
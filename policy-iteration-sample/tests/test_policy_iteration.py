from unittest import TestCase
from src.policy import PolicyIteration
from src.tabular_policy import TabularPolicy
from src.tabular_value_function import TabularValueFunction
from src.qtable import QTable
from src.mdp.gridworld import GridWorld

class TestPolicyIteration(TestCase):

    def setUp(self):
        self.mdp = GridWorld()  # Initialize the MDP (GridWorld)
        self.policy = TabularPolicy(self.mdp.get_states())  # Initialize a policy
        self.policy_iteration = PolicyIteration(self.mdp, self.policy)  # Create PolicyIteration instance

    def test_policy_evaluation(self):
        values = TabularValueFunction()
        evaluated_values = self.policy_iteration.policy_evaluation(self.policy, values)
        self.assertIsNotNone(evaluated_values)

    def test_policy_iteration(self):
        iterations = self.policy_iteration.policy_iteration()
        self.assertGreater(iterations, 0)  # Ensure that at least one iteration occurs

    def test_policy_convergence(self):
        initial_action = self.policy.select_action(self.mdp.get_states()[0], self.mdp.get_actions(self.mdp.get_states()[0]))
        self.policy_iteration.policy_iteration()
        new_action = self.policy.select_action(self.mdp.get_states()[0], self.mdp.get_actions(self.mdp.get_states()[0]))
        self.assertNotEqual(initial_action, new_action)  # Ensure the policy has changed

    def test_q_table_update(self):
        values = TabularValueFunction()
        q_table = QTable(alpha=1.0)
        for state in self.mdp.get_states():
            for action in self.mdp.get_actions(state):
                q_value = values.get_q_value(self.mdp, state, action)
                q_table.update(state, action, q_value)
                self.assertEqual(q_table.get_value(state, action), q_value)  # Check if Q-value is updated correctly
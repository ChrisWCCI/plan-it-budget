import React, { useState, useEffect } from "react";
import { Modal, Button, Form, Stack } from "react-bootstrap";
import { currencyFormatter } from "./Utils";
import {
  UNCATEGORIZED_BUDGET_ID,
  useBudgets,
} from "../contexts/BudgetsContext";

export default function ViewExpensesModal({ budgetId, handleClose }) {
  const {
    getBudgetExpenses,
    budgets,
    editExpense,
    deleteExpense,
    deleteBudget,
  } = useBudgets();
  const [editedDescription, setEditedDescription] = useState("");
  const [editedAmount, setEditedAmount] = useState("");
  const [selectedExpense, setSelectedExpense] = useState(null);

  const expenses = getBudgetExpenses(budgetId);

  const budget =
    UNCATEGORIZED_BUDGET_ID === budgetId
      ? { name: "Uncategorized", id: UNCATEGORIZED_BUDGET_ID }
      : budgets.find((b) => b.id === budgetId);

  useEffect(() => {
    const handleKeyDown = (event) => {
      if (event.key === "Enter") {
        handleSaveChanges();
      }
    };

    document.addEventListener("keydown", handleKeyDown);

    return () => {
      document.removeEventListener("keydown", handleKeyDown);
    };
  }, [editedDescription, editedAmount, selectedExpense]);

  const handleEditClick = (expense) => {
    setSelectedExpense(expense);
    setEditedDescription(expense.description);
    setEditedAmount(expense.chargeAmount);
  };

  const handleSaveChanges = () => {
    if (selectedExpense) {
      editExpense({
        id: selectedExpense.id,
        description: editedDescription,
        chargeAmount: parseFloat(editedAmount),
        budgetId: selectedExpense.budget.id,
      });
      setSelectedExpense(null);
      handleClose();
    }
  };

  const handleDeleteClick = (expense) => {
    if (window.confirm("Are you sure you want to delete this expense?")) {
      deleteExpense(expense);
    }
  };

  return (
    <Modal show={budgetId != null} onHide={handleClose}>
      <Modal.Header closeButton>
        <Modal.Title>
          <Stack direction="horizontal" gap="2">
            <div>{budget?.budgetName} - Expenses</div>
            <Button
              onClick={() => {
                deleteBudget(budget);
                handleClose();
              }}
              variant="outline-danger"
            >
              Delete Budget
            </Button>
          </Stack>
        </Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <Stack direction="vertical" gap="3">
          {expenses.map((expense) => (
            <Stack direction="horizontal" gap="2" key={expense.id}>
              <div className="me-auto fs-4">{expense.description}</div>
              <div className="me-3 fs-5">
                {currencyFormatter.format(expense.chargeAmount)}
              </div>
              <Button
                onClick={() => handleEditClick(expense)}
                size="sm"
                variant="outline-danger"
              >
                Edit
              </Button>
              <Button
                onClick={() => handleDeleteClick(expense)}
                size="sm"
                variant="outline-danger"
              >
                Delete
              </Button>
            </Stack>
          ))}
        </Stack>
        {selectedExpense && (
          <Modal
            show={selectedExpense !== null}
            onHide={() => setSelectedExpense(null)}
          >
            <Modal.Header closeButton>
              <Modal.Title>Edit Expense</Modal.Title>
            </Modal.Header>
            <Modal.Body>
              <Form.Group controlId="editDescription">
                <Form.Label>Description</Form.Label>
                <Form.Control
                  type="text"
                  value={editedDescription}
                  onChange={(e) => setEditedDescription(e.target.value)}
                />
              </Form.Group>
              <Form.Group controlId="editAmount">
                <Form.Label>Amount</Form.Label>
                <Form.Control
                  type="number"
                  value={editedAmount}
                  onChange={(e) => setEditedAmount(e.target.value)}
                />
              </Form.Group>
            </Modal.Body>
            <Modal.Footer>
              <Button
                variant="secondary"
                onClick={() => setSelectedExpense(null)}
              >
                Cancel
              </Button>
              <Button variant="primary" onClick={handleSaveChanges}>
                Save Changes
              </Button>
            </Modal.Footer>
          </Modal>
        )}
      </Modal.Body>
    </Modal>
  );
}
